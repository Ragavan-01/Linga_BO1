package epicList_Integrated;import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

	import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

	public class StoreLevel_Report1 {
	public WebDriver driver;
	
		
		ExtentReports rep = ExtentManager.getInstance();
		ExtentTest test = rep.startTest("Verify_Storelevel_Report1");

		float unknownValue = 00;
		
		@AfterClass
			public void flushTest() throws Exception
		{
			Thread.sleep(2000);
			rep.endTest(test);
			rep.flush();
		}

		@AfterMethod
			public void tearDown(ITestResult result)
		{
			if(ITestResult.FAILURE == result.getStatus())
			{
				Utility.captureScreenshot(driver, result.getName());
			}
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
		
		@Test(priority=2,enabled = true)
			public void Department_Sale_method_OpenReport(WebDriver driver) throws Exception
		{
			Thread.sleep(15000);
			//Click the Reports option
			driver.findElement(By.xpath("//span[.='Reports']")).click();
			// Create instance of Java script executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element = driver.findElement(By.xpath("//span[.='Sale']"));Thread.sleep(3000);
			//Scroll the page till the Sale option present
			je.executeScript("arguments[0].scrollIntoView(true);",element); Thread.sleep(3000);
	        //Click the Sale Option		
			driver.findElement(By.xpath("//span[.='Sale']")).click();
			Thread.sleep(3000);
			//Check Sale Report page opened or not
			if(driver.findElement(By.xpath("//a[.='Sale report']")).getText().equalsIgnoreCase("Sale report"))
			{
				test.log(LogStatus.PASS, "Department Sale report page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Department Sale report page loaded Failed");
			}
			
			Thread.sleep(3000);

		}
		
			@Test(priority=4,enabled = true)
			public void Department_Sale_method_Report_For_Specific_Date_With_Quantity_Sort(WebDriver driver) throws Exception
			{
				Thread.sleep(2000);
				WebElement html = driver.findElement(By.tagName("html"));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		
				Thread.sleep(5000);
				//Click the Department option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required department
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				//Check whether the Quantity sort is enabled or not
				if(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']")).isSelected())
				{
					
				}
				else
				{
					//Click the Quantity Sort option
					Actions act = new Actions(driver);
					act.moveToElement(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']/../span"))).click().build().perform();			
				}
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Number of rows
				List<WebElement> rowss = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
				int rowa = rowss.size()-1;
				ArrayList<Integer> array = new ArrayList<Integer>();
				for(int i =1; i <= rowa; i++)
				{
					String quan = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+i+"]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
					Integer dquan = Integer.parseInt(quan);
					//int quantity = quan.intValue();
					array.add(dquan);
				}
				Collections.sort(array);
				for(int i =0; i < rowa; i++)
				{	int s = i+1;
					String e = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+s+"]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
					double actual = Double.parseDouble(e);
					double expect = array.get(i);
					if(actual != expect)
					{
						test.log(LogStatus.PASS, "Sorted by Quantity is Fail");
					}
				}
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Department Sale Report is not available for Specific Date");
				}
				else
				{
					test.log(LogStatus.PASS, "Department Sale Report available for Specific Date");
					
					Thread.sleep(3000);
					//Check Weather the Top 5 department sale available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Here Top 5 Department Sale Report available for Specific Date");
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);
						
						//Click the Pie chart option
						driver.findElement(By.xpath("//a[.='Pie']")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Pie Chart available");
						Thread.sleep(3000);
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);
		
						//Click the Polar Area chart option
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/ul/li[2]/a")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Polar Area Chart available");
						Thread.sleep(3000);
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);
		
						//Click the Bar chart option
						driver.findElement(By.xpath("//a[.='Bar']")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Bar Chart available");
						Thread.sleep(3000);
					}
					else
					{
						test.log(LogStatus.FAIL, "Here Top 5 Department Sale Report not available for Specific Date");
					}
					
					Thread.sleep(5000);
					//Check weather the report graph is available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
					{
						test.log(LogStatus.PASS, "There is Graphical type of department sale report is available for Specific Date");
					}
					else
					{
						test.log(LogStatus.FAIL, "Graphical report is not available for Specific Date");
					}
					
					Thread.sleep(5000);
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for Specific Date");
						
						Thread.sleep(3000);
				        //No.of rows
				        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
				        
		/*	        //Print number of Rows
				        System.out.println("Number of Rows are : "+rows);*/
				        
			        	
			        	//Replace all commo's with empty space
			        	String expected1 = Utility.getReportProperty("Sale_Report_Sale_Amount").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Sale_Amount element into float value
			        	float expect1 = Float.parseFloat(expected1);  
			        		        	
			        	//Replace all commo's with empty space
			        	String expected2 = Utility.getReportProperty("Sale_Report_Quantity").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Quantity element into float value
			        	float expect2 = Float.parseFloat(expected2);  
			        	
			        	//Replace all commo's with empty space
			        	String expected3 = Utility.getReportProperty("Sale_Report_Tax").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Tax element into float value
			        	float expect3 = Float.parseFloat(expected3);  
		
			        	//Replace all commo's with empty space
			        	String expected4 = Utility.getReportProperty("Sale_Report_Discount").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Discount element into float value
			        	float expect4 = Float.parseFloat(expected4);  
			        	
			        	//Replace all commo's with empty space
			        	String expected5 = Utility.getReportProperty("Sale_Report_Percentage_Of_Sale").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Percentage_Of_Sale element into float value
			        	float expect5 = Float.parseFloat(expected5);                              
				        
				        //Check weather the Sale Amount Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Sale_Amount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Sale Amount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Sale Amount Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Sale Amount Value is : "+ actual);
				        }
				        
						else if(expect1 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Check Count
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
		
				        	System.out.println("The Actual Sale Amount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Sale Amount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the sale amount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect1;
				        	
				        	//Print the different value
				        	System.out.println("Sale Amount Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Sale Amount Value different is : "+different);	
				        }
				        
				        //Check weather the Quantity Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Quantity")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Quantity");
				        	
				        	//Get the Total value of Quantity
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Quantity Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Quantity Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Quantity Value is : "+ actual);
				        }
				        
						else if(expect2 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Quantity
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		
				        	System.out.println("The Actual Quantity value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Quantity value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Quantity");
				        	
				        	//Get the Total value of Quantity
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Quantity Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Get the different
				        	float different = actual - expect2;
				        	
				        	//Print the different value
				        	System.out.println("Quantity Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Quantity Value different is : "+different);	
				        }
				        
				        //Check weather the Tax Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");   	
		
				        	//Convert the String value of the Tax Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Tax Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Tax Value is : "+ actual);
				        }
				        
						else if(expect3 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Tax
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		
				        	System.out.println("The Actual Tax value is : "+actualText);		 
				        	
				        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Tax Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect3;
				        	
				        	//Print the different value
				        	System.out.println("Tax Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Tax Value different is : "+different);	
				        }
				        
				        //Check weather the Discount Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Discount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Discount Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Discount Value is : "+ actual);
				        }
				        
						else if(expect4 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Discount
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		
				        	System.out.println("The Actual Discount value is : "+actualText);	
				        	
				        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Discount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect4;
				        	
				        	//Print the different value
				        	System.out.println("Discount Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Discount Value different is : "+different);	
				        }
				        
				        //Check weather the Percentage Of Sale Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Percentage_Of_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Percentage Of Sale");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Percentage of Sale Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Percentage Of Sale Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Percentage Of Sale Value is : "+ actual);
				        }
				        
						else if(expect5 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Percentage Of Sale
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
		
				        	System.out.println("The Actual Percentage Of Sale value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Percentage Of Sale value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Percentage Of Sale");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Percentage Of Sale Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect5;
				        	
				        	//Print the different value
				        	System.out.println("Percentage Of Sale Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Percentage Of Sale Value different is : "+different);	
				        }
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for Specific Date");
					}
				}
			}
			
			@Test(priority=3,enabled = true)
			public void Department_Sale_method_Report_For_Specific_Date(WebDriver driver) throws Exception
			{
				Thread.sleep(2000);
				WebElement html = driver.findElement(By.tagName("html"));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		
				Thread.sleep(3000);
				//Click the Department option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required department
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				//Check whether the Quantity sort is enabled or not
				if(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']")).isSelected())
				{
					//Click the Quantity Sort option
					Actions act = new Actions(driver);
					act.moveToElement(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']/../span"))).click().build().perform();			
				}
				else
				{
				}
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Department Sale Report is not available for the Required Date Range");
				}
				else
				{
					test.log(LogStatus.PASS, "Department Sale Report available for the Required Date Range");
					
					Thread.sleep(3000);
					//Check Weather the Top 5 department sale available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Here Top 5 Department Sale Report available for the Required Date Range");
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);
						
						//Click the Pie chart option
						driver.findElement(By.xpath("//a[.='Pie']")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Pie Chart available");
						Thread.sleep(3000);
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);
		
						//Click the Polar Area chart option
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/ul/li[2]/a")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Polar Area Chart available");
						Thread.sleep(3000);
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);
		
						//Click the Bar chart option
						driver.findElement(By.xpath("//a[.='Bar']")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Bar Chart available");
						Thread.sleep(3000);
					}
					else
					{
						test.log(LogStatus.FAIL, "Here Top 5 Department Sale Report not available for the Required Date Range");
					}
					
					Thread.sleep(3000);
					//Check weather the report graph is available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
					{
						test.log(LogStatus.PASS, "There is Graphical type of department sale report is available for the Required Date Range");
					}
					else
					{
						test.log(LogStatus.FAIL, "Graphical report is not available for the Required Date Range");
					}
					
					Thread.sleep(3000);
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						Thread.sleep(3000);
				        //No.of rows
				        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
				        
		/*	        //Print number of Rows
				        System.out.println("Number of Rows are : "+rows);*/
				        
			        	
			        	//Replace all commo's with empty space
			        	String expected1 = Utility.getReportProperty("Sale_Report_Sale_Amount").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Sale_Amount element into float value
			        	float expect1 = Float.parseFloat(expected1);  
			        		        	
			        	//Replace all commo's with empty space
			        	String expected2 = Utility.getReportProperty("Sale_Report_Quantity").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Quantity element into float value
			        	float expect2 = Float.parseFloat(expected2);  
			        	
			        	//Replace all commo's with empty space
			        	String expected3 = Utility.getReportProperty("Sale_Report_Tax").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Tax element into float value
			        	float expect3 = Float.parseFloat(expected3);  
		
			        	//Replace all commo's with empty space
			        	String expected4 = Utility.getReportProperty("Sale_Report_Discount").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Discount element into float value
			        	float expect4 = Float.parseFloat(expected4);  
			        	
			        	//Replace all commo's with empty space
			        	String expected5 = Utility.getReportProperty("Sale_Report_Percentage_Of_Sale").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Percentage_Of_Sale element into float value
			        	float expect5 = Float.parseFloat(expected5);                              
				        
				        //Check weather the Sale Amount Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Sale_Amount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Sale Amount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Sale Amount Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Sale Amount Value is : "+ actual);
				        }
				        
						else if(expect1 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Check Count
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
		
				        	System.out.println("The Actual Sale Amount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Sale Amount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the sale amount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect1;
				        	
				        	//Print the different value
				        	System.out.println("Sale Amount Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Sale Amount Value different is : "+different);	
				        }
				        
				        //Check weather the Quantity Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Quantity")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Quantity");
				        	
				        	//Get the Total value of Quantity
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Quantity Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Quantity Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Quantity Value is : "+ actual);
				        }
				        
						else if(expect2 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Quantity
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		
				        	System.out.println("The Actual Quantity value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Quantity value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Quantity");
				        	
				        	//Get the Total value of Quantity
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Quantity Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Get the different
				        	float different = actual - expect2;
				        	
				        	//Print the different value
				        	System.out.println("Quantity Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Quantity Value different is : "+different);	
				        }
				        
				        //Check weather the Tax Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");   	
		
				        	//Convert the String value of the Tax Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Tax Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Tax Value is : "+ actual);
				        }
				        
						else if(expect3 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Tax
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		
				        	System.out.println("The Actual Tax value is : "+actualText);		 
				        	
				        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Tax Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect3;
				        	
				        	//Print the different value
				        	System.out.println("Tax Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Tax Value different is : "+different);	
				        }
				        
				        //Check weather the Discount Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Discount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Discount Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Discount Value is : "+ actual);
				        }
				        
						else if(expect4 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Discount
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		
				        	System.out.println("The Actual Discount value is : "+actualText);	
				        	
				        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Discount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect4;
				        	
				        	//Print the different value
				        	System.out.println("Discount Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Discount Value different is : "+different);	
				        }
				        
				        //Check weather the Percentage Of Sale Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Percentage_Of_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Percentage Of Sale");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Percentage of Sale Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Percentage Of Sale Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Percentage Of Sale Value is : "+ actual);
				        }
				        
						else if(expect5 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Percentage Of Sale
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
		
				        	System.out.println("The Actual Percentage Of Sale value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Percentage Of Sale value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Department Sale reports are different for Percentage Of Sale");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Percentage Of Sale Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect5;
				        	
				        	//Print the different value
				        	System.out.println("Percentage Of Sale Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Percentage Of Sale Value different is : "+different);	
				        }
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for the Required Date Range");
					}
				}
			}
		
			@Test(priority=6,enabled = true)
			public void Department_Sale_method_Report_For_Specific_Date_With_Quantity_Sort_And_Dynamic_Report(WebDriver driver) throws Exception
			{
				Thread.sleep(2000);
				WebElement html = driver.findElement(By.tagName("html"));
				html.sendKeys(Keys.HOME);
		
				Thread.sleep(5000);
				//Click the Department option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required department
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				//Check whether the Quantity sort is enabled or not
				if(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']")).isSelected())
				{
					
				}
				else
				{
					//Click the Quantity Sort option
					Actions act = new Actions(driver);
					act.moveToElement(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']/../span"))).click().build().perform();			
				}
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				for(int i = 1; i <= 8; i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}Thread.sleep(3000);
				
				//Check Whether all the field is selected or not
				if(driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'% of Sale')]/../input")).isSelected())
				{
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						//Check whether all the filed is available or not
						if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'% of Sale')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed())
						{
							test.log(LogStatus.PASS, "All the Neccessary fields are displayed");
						}
						else
						{
							test.log(LogStatus.FAIL, "Neccessary fields are not displayed");
						}
						
						//Disable the required option from enable to disable Sale Amount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected())
						{
							//Click the Enabled Sale Amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Sale Amount')]"))).click().build().perform();
							try
							{
								//Check whether the Sale Amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Sale Amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Sale Amount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Sale Amount Option is Disabled When user enter the required date for date range");
						}
						
						//Disable the required option from enable to disable Quantity Option
						if(driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected())
						{
							//Click the Enabled Quantity Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Quantity')]"))).click().build().perform();
							try
							{
								//Check whether the Quantity Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Quantity is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Quantity is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Quantity Option is Disabled When user enter the required date for date range");
						}
						
						//Disable the required option from enable to disable Tax Option
						if(driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected())
						{
							//Click the Enabled Tax Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Tax')]"))).click().build().perform();
							try
							{
								//Check whether the Tax Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Tax is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Tax is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Tax Option is Disabled When user enter the required date for date range");
						}
						
						//Disable the required option from enable to disable Discount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
						{
							//Click the Enabled Discount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
							try
							{
								//Check whether the Discount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Discount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Discount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Discount Option is Disabled When user enter the required date for date range");
						}
						
						//Disable the required option from enable to disable % Of Sale Option
						if(driver.findElement(By.xpath("//span[contains(.,'% of Sale')]/../input")).isSelected())
						{
							//Click the Enabled % Of Sale Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'% of Sale')]"))).click().build().perform();
							try
							{
								//Check whether the % Of Sale Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'% of Sale')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "% Of Sale is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "% Of Sale is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "% Of Sale Option is Disabled When user enter the required date for date range");
						}
						//Enable the Sale Amount Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Sale Amount Option is Enabled after user click(Disable) the Sale Amount option");
		
						}
						else
						{
							//Click the Enabled Sale Amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Sale Amount')]"))).click().build().perform();
							try
							{
								//Check whether the Sale Amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Sale Amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Sale Amount is not displayed");
							}				}
						
						//Disable the required option from enable to disable Quantity Option
						if(driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Quantity Option is Enabled after user click(Disable) the Quantity option");
						}
						else
						{
							//Click the Enabled Quantity Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Quantity')]"))).click().build().perform();
							try
							{
								//Check whether the Quantity Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Quantity is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Quantity is not displayed");
							}
		
						}
						
						//Disable the required option from enable to disable Tax Option
						if(driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Tax Option is Enabled after user click(Disable) the Tax option");
						}
						else
						{
		
							//Click the Enabled Tax Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Tax')]"))).click().build().perform();
							try
							{
								//Check whether the Tax Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Tax is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Tax is not displayed");
							}
		
						}
						
						//Disable the required option from enable to disable Discount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Discount Option is Enabled after user click(Disable) the Discount option");
		
						}
						else
						{
		
							//Click the Enabled Discount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
							try
							{
								//Check whether the Discount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Discount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Discount is not displayed");
							}
						}
						
						//Disable the required option from enable to disable % Of Sale Option
						if(driver.findElement(By.xpath("//span[contains(.,'% of Sale')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "% Of Sale Option is Enabled after user click(Disable) the % of Sale option");
		
						}
						else
						{
		
							//Click the Enabled % Of Sale Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'% of Sale')]"))).click().build().perform();
							try
							{
								//Check whether the % Of Sale Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'% of Sale')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "% Of Sale is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "% Of Sale is not displayed");
							}
						}
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for the Required Date Range");
					}
					
				}
				else
				{
					test.log(LogStatus.FAIL, "All dynamic option is not selected");
				}
			}
			
			@Test(priority=5,enabled = true)
			public void Department_Sale_method_Report_For_Specific_Date_Without_Quantity_Sort_With_Dynamic_Report(WebDriver driver) throws Exception
		{
			Thread.sleep(2000);
			WebElement html = driver.findElement(By.tagName("html"));
			html.sendKeys(Keys.HOME);
	
			Thread.sleep(3000);
			//Click the Department option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
			//Enter the required department
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
			//Press the Enter Key
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
			Thread.sleep(3000);
			//Click the Time Period option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
			//Enter the required Time Period
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("Date Range");
			//Press the Enter Key
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).clear();
			//Enter the date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
			Thread.sleep(2000);
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).clear();
			//Enter the date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			
			//Check whether the Quantity sort is enabled or not
			if(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']")).isSelected())
			{
				//Click the Quantity Sort option
				Actions act = new Actions(driver);
				act.moveToElement(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']/../span"))).click().build().perform();			
			}
			else
			{
			}
			
			Thread.sleep(2000);
			//Click the Run Button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			Thread.sleep(2000);
			//Click the Run Button
			for(int i = 1; i <= 8; i++)
			{
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			}Thread.sleep(3000);
			
			//Check Whether all the field is selected or not
			if(driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected()
					&&driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected()
					&&driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected()
					&&driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected()
					&&driver.findElement(By.xpath("//span[contains(.,'% of Sale')]/../input")).isSelected())
			{
				//Check weather the table format report is available or not
				if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
					
					//Check whether all the filed is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'% of Sale')]")).isDisplayed()
							&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed()
							&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed()
							&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed()
							&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "All the Neccessary fields are displayed");
					}
					else
					{
						test.log(LogStatus.FAIL, "Neccessary fields are not displayed");
					}
					
					//Disable the required option from enable to disable Sale Amount Option
					if(driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected())
					{
						//Click the Enabled Sale Amount Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Sale Amount')]"))).click().build().perform();
						try
						{
							//Check whether the Sale Amount Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed())
							{
								test.log(LogStatus.FAIL, "Sale Amount is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.PASS, "Sale Amount is not displayed");
						}
					}
					else
					{
						test.log(LogStatus.FAIL, "Sale Amount Option is Disabled When user enter the required date for date range");
					}
					
					//Disable the required option from enable to disable Quantity Option
					if(driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected())
					{
						//Click the Enabled Quantity Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Quantity')]"))).click().build().perform();
						try
						{
							//Check whether the Quantity Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed())
							{
								test.log(LogStatus.FAIL, "Quantity is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.PASS, "Quantity is not displayed");
						}
					}
					else
					{
						test.log(LogStatus.FAIL, "Quantity Option is Disabled When user enter the required date for date range");
					}
					
					//Disable the required option from enable to disable Tax Option
					if(driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected())
					{
						//Click the Enabled Tax Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Tax')]"))).click().build().perform();
						try
						{
							//Check whether the Tax Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed())
							{
								test.log(LogStatus.FAIL, "Tax is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.PASS, "Tax is not displayed");
						}
					}
					else
					{
						test.log(LogStatus.FAIL, "Tax Option is Disabled When user enter the required date for date range");
					}
					
					//Disable the required option from enable to disable Discount Option
					if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
					{
						//Click the Enabled Discount Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
						try
						{
							//Check whether the Discount Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
							{
								test.log(LogStatus.FAIL, "Discount is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.PASS, "Discount is not displayed");
						}
					}
					else
					{
						test.log(LogStatus.FAIL, "Discount Option is Disabled When user enter the required date for date range");
					}
					
					//Disable the required option from enable to disable % Of Sale Option
					if(driver.findElement(By.xpath("//span[contains(.,'% of Sale')]/../input")).isSelected())
					{
						//Click the Enabled % Of Sale Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'% of Sale')]"))).click().build().perform();
						try
						{
							//Check whether the % Of Sale Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'% of Sale')]")).isDisplayed())
							{
								test.log(LogStatus.FAIL, "% Of Sale is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.PASS, "% Of Sale is not displayed");
						}
					}
					else
					{
						test.log(LogStatus.FAIL, "% Of Sale Option is Disabled When user enter the required date for date range");
					}
					
					//Enable the Sale Amount Option if it is in disabled status
					if(driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected())
					{
						test.log(LogStatus.FAIL, "Sale Amount Option is Enabled after user click(Disable) the Sale Amount option");
	
					}
					else
					{
						//Click the Enabled Sale Amount Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Sale Amount')]"))).click().build().perform();
						try
						{
							//Check whether the Sale Amount Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed())
							{
								test.log(LogStatus.PASS, "Sale Amount is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Sale Amount is not displayed");
						}				}
					
					//Disable the required option from enable to disable Quantity Option
					if(driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected())
					{
						test.log(LogStatus.FAIL, "Quantity Option is Enabled after user click(Disable) the Quantity option");
					}
					else
					{
						//Click the Enabled Quantity Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Quantity')]"))).click().build().perform();
						try
						{
							//Check whether the Quantity Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed())
							{
								test.log(LogStatus.PASS, "Quantity is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Quantity is not displayed");
						}
	
					}
					
					//Disable the required option from enable to disable Tax Option
					if(driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected())
					{
						test.log(LogStatus.FAIL, "Tax Option is Enabled after user click(Disable) the Tax option");
					}
					else
					{
	
						//Click the Enabled Tax Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Tax')]"))).click().build().perform();
						try
						{
							//Check whether the Tax Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed())
							{
								test.log(LogStatus.PASS, "Tax is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Tax is not displayed");
						}
	
					}
					
					//Disable the required option from enable to disable Discount Option
					if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
					{
						test.log(LogStatus.FAIL, "Discount Option is Enabled after user click(Disable) the Discount option");
	
					}
					else
					{
	
						//Click the Enabled Discount Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
						try
						{
							//Check whether the Discount Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
							{
								test.log(LogStatus.PASS, "Discount is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Discount is not displayed");
						}
					}
					
					//Disable the required option from enable to disable % Of Sale Option
					if(driver.findElement(By.xpath("//span[contains(.,'% of Sale')]/../input")).isSelected())
					{
						test.log(LogStatus.FAIL, "% Of Sale Option is Enabled after user click(Disable) the % of Sale option");
	
					}
					else
					{
	
						//Click the Enabled % Of Sale Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'% of Sale')]"))).click().build().perform();
						try
						{
							//Check whether the % Of Sale Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'% of Sale')]")).isDisplayed())
							{
								test.log(LogStatus.PASS, "% Of Sale is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "% Of Sale is not displayed");
						}
					}
				}
				else
				{
					test.log(LogStatus.FAIL, "Table Format Report is not available for the Required Date Range");
				}
				
			}
			else
			{
				test.log(LogStatus.FAIL, "All dynamic option is not selected");
			}
	
		}
		
			@Test(priority=20,enabled = true)
			public void Category_Sale_method_openpage_Report(WebDriver driver) throws Exception
			{
			/*	//Click the Reports option
				driver.findElement(By.xpath("//span[.='Reports']")).click();
				// Create instance of Java script executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath("//span[.='Sale']"));
				//Scroll the page till the Sale option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        //Click the Sale Option		
				driver.findElement(By.xpath("//span[.='Sale']")).click();*/
				
				Thread.sleep(3000);
				//Enter the Categories Url
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/categorySale");
				
				Thread.sleep(5000);
				
				//Check Category Sale Report page opened or not
				if(driver.findElement(By.xpath("//label[.='Category']")).getText().equalsIgnoreCase("Category"))
				{
					test.log(LogStatus.PASS, "Category Sale report page loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Category Sale report page loaded Failed");
				}
				
				Thread.sleep(3000);
			}
			
			@Test(priority=21,enabled = true)
			public void Category_Sale_method__Report_For_Specific_Date(WebDriver driver) throws Exception
			{
				Thread.sleep(2000);
				WebElement html = driver.findElement(By.tagName("html"));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));

				Thread.sleep(3000);
				//Click the Category option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required Category
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				//Check whether the Quantity sort is enabled or not
				if(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']")).isSelected())
				{
					//Click the Quantity Sort option
					Actions act = new Actions(driver);
					act.moveToElement(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']/../span"))).click().build().perform();
				}
				else
				{
				}
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Category Sale Report is not available for the Required Date Range");
				}
				else
				{
					test.log(LogStatus.PASS, "Category Sale Report available for the Required Date Range");
					
					Thread.sleep(3000);
					//Check Weather the Top 5 category sale available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Here Top 5 Category Sale Report available for the Required Date Range");
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);
						
						//Click the Pie chart option
						driver.findElement(By.xpath("//a[.='Pie']")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Pie Chart available");
						Thread.sleep(3000);
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);

						//Click the Polar Area chart option
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/ul/li[2]/a")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Polar Area Chart available");
						Thread.sleep(3000);
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);

						//Click the Bar chart option
						driver.findElement(By.xpath("//a[.='Bar']")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Bar Chart available");
						Thread.sleep(3000);
					}
					else
					{
						test.log(LogStatus.FAIL, "Here Top 5 Category	 Sale Report not available for the Required Date Range");
					}
					
					Thread.sleep(3000);
					//Check weather the report graph is available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
					{
						test.log(LogStatus.PASS, "There is Graphical type of category sale report is available for the Required Date Range");
					}
					else
					{
						test.log(LogStatus.FAIL, "Graphical report is not available for the Required Date Range");
					}
					
					Thread.sleep(3000);
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						Thread.sleep(3000);
				        //No.of rows
				        List<WebElement> rows = driver.findElements(By.xpath ("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
				        
		/*		        //Print number of Rows
				        System.out.println("Number of Rows are : "+rows);*/
				        
			        	//Replace all commo's with empty space
			        	String expected1 = Utility.getReportProperty("Sale_Report_Sale_Amount").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Sale_Amount element into float value
			        	float expect1 = Float.parseFloat(expected1);  
			        	
			        	//Replace all commo's with empty space
			        	String expected2 = Utility.getReportProperty("Sale_Report_Quantity").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Quantity element into float value
			        	float expect2 = Float.parseFloat(expected2);  
			        	
			        	//Replace all commo's with empty space
			        	String expected3 = Utility.getReportProperty("Sale_Report_Tax").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Tax element into float value
			        	float expect3 = Float.parseFloat(expected3);  
			        	
			        	//Replace all commo's with empty space
			        	String expected4 = Utility.getReportProperty("Sale_Report_Discount").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Discount element into float value
			        	float expect4 = Float.parseFloat(expected4);  
				        
			        	//Replace all commo's with empty space
			        	String expected5 = Utility.getReportProperty("Sale_Report_Percentage_Of_Sale").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Percentage_Of_Sale element into float value
			        	float expect5 = Float.parseFloat(expected5);   
				        
				        //Check weather the Sale Amount Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Sale_Amount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Category Sale reports are same for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Sale Amount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Sale Amount Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Sale Amount Value is : "+ actual);
				        }
				        
						else if(expect1 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Sale Amount
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();

				        	System.out.println("The Actual Sale Amount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Sale Amount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Category Sale reports are different for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the sale amount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        			        	
				        	//Get the different
				        	float different = actual - expect1;
				        	
				        	//Print the different value
				        	System.out.println("Sale Amount Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Sale Amount Value different is : "+different);	
				        }
				        
				        //Check weather the Quantity Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Quantity")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Category Sale reports are same for Quantity");
				        	
				        	//Get the Total value of Quantity
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Quantity Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Quantity Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Quantity Value is : "+ actual);
				        }
				        
						else if(expect2 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Quantity
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();

				        	System.out.println("The Actual Quantity value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Quantity value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Category Sale reports are different for Quantity");
				        	
				        	//Get the Total value of Quantity
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Quantity Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect2;
				        	
				        	//Print the different value
				        	System.out.println("Quantity Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Quantity Value different is : "+different);	
				        }
				        
				        
				        //Check weather the Tax Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Category Sale reports are same for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");   	

				        	//Convert the String value of the Tax Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Tax Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Tax Value is : "+ actual);
				        }
				        
						else if(expect3 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Tax
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();

				        	System.out.println("The Actual Tax value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Category Sale reports are different for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Tax Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect3;
				        	
				        	//Print the different value
				        	System.out.println("Tax Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Tax Value different is : "+different);	
				        }
				        
				        //Check weather the Discount Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Category Sale reports are same for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Discount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Discount Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Discount Value is : "+ actual);
				        }
				        
						else if(expect4 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Discount
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();

				        	System.out.println("The Actual Discount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Category Sale reports are different for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Discount Total element into float value
				        	float actual = Float.parseFloat(actualText);  	
				        	
				        	//Get the different
				        	float different = actual - expect4;
				        	
				        	//Print the different value
				        	System.out.println("Discount Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Discount Value different is : "+different);	
				        }
				        
				        //Check weather the Percentage Of Sale Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Percentage_Of_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Category Sale reports are same for Percentage Of Sale");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Percentage of Sale Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Percentage Of Sale Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Percentage Of Sale Value is : "+ actual);
				        }
				        
						else if(expect5 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Percentage Of Sale
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();

				        	System.out.println("The Actual Percentage Of Sale value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Percentage Of Sale value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Category Sale reports are different for Percentage Of Sale");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Percentage Of Sale Total element into float value
				        	float actual = Float.parseFloat(actualText);       		
				        	
				        	//Get the different
				        	float different = actual - expect5;
				        	
				        	//Print the different value
				        	System.out.println("Percentage Of Sale Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Percentage Of Sale Value different is : "+different);	
				        }
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for the Required Date Range");
					}
				}
			}

			@Test(priority=22,enabled = true)
			public void Category_Sale_method__Report_For_Specific_Date_With_Quantity_Sort(WebDriver driver) throws Exception
			{
				Thread.sleep(2000);
				WebElement html = driver.findElement(By.tagName("html"));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));

				Thread.sleep(3000);
				//Click the Category option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required Category
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				//Check whether the Quantity sort is enabled or not
				if(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']")).isSelected())
				{
					
				}
				else
				{
					//Click the Quantity Sort option
					Actions act = new Actions(driver);
					act.moveToElement(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']/../span"))).click().build().perform();
				}
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Number of rows
				List<WebElement> rowss = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr"));
				int rowa = rowss.size()-1;
				ArrayList<Integer> array = new ArrayList<Integer>();
				for(int i =1; i <= rowa; i++)
				{
					String quan = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr["+i+"]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
					Integer dquan = Integer.parseInt(quan);
					//int quantity = quan.intValue();
					array.add(dquan);
				}
				Collections.sort(array);
				for(int i =0; i < rowa; i++)
				{	int s = i+1;
					String e = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr["+s+"]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
					double actual = Double.parseDouble(e);
					double expect = array.get(i);
					if(actual != expect)
					{
						test.log(LogStatus.PASS, "Sorted by Quantity is Fail");
					}
				}
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Category Sale Report is not available for the Required Date Range");
				}
				else
				{
					test.log(LogStatus.PASS, "Category Sale Report available for the Required Date Range");
					
					Thread.sleep(3000);
					//Check Weather the Top 5 category sale available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Here Top 5 Category Sale Report available for the Required Date Range");
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);
						
						//Click the Pie chart option
						driver.findElement(By.xpath("//a[.='Pie']")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Pie Chart available");
						Thread.sleep(3000);
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);

						//Click the Polar Area chart option
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/ul/li[2]/a")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Polar Area Chart available");
						Thread.sleep(3000);
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);

						//Click the Bar chart option
						driver.findElement(By.xpath("//a[.='Bar']")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Bar Chart available");
						Thread.sleep(3000);
					}
					else
					{
						test.log(LogStatus.FAIL, "Here Top 5 Category	 Sale Report not available for the Required Date Range");
					}
					
					Thread.sleep(3000);
					//Check weather the report graph is available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
					{
						test.log(LogStatus.PASS, "There is Graphical type of category sale report is available for the Required Date Range");
					}
					else
					{
						test.log(LogStatus.FAIL, "Graphical report is not available for the Required Date Range");
					}
					
					Thread.sleep(3000);
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						Thread.sleep(3000);
				        //No.of rows
				        List<WebElement> rows = driver.findElements(By.xpath ("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
				        
		/*		        //Print number of Rows
				        System.out.println("Number of Rows are : "+rows);*/
				        
			        	//Replace all commo's with empty space
			        	String expected1 = Utility.getReportProperty("Sale_Report_Sale_Amount").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Sale_Amount element into float value
			        	float expect1 = Float.parseFloat(expected1);  
			        	
			        	//Replace all commo's with empty space
			        	String expected2 = Utility.getReportProperty("Sale_Report_Quantity").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Quantity element into float value
			        	float expect2 = Float.parseFloat(expected2);  
			        	
			        	//Replace all commo's with empty space
			        	String expected3 = Utility.getReportProperty("Sale_Report_Tax").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Tax element into float value
			        	float expect3 = Float.parseFloat(expected3);  
			        	
			        	//Replace all commo's with empty space
			        	String expected4 = Utility.getReportProperty("Sale_Report_Discount").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Discount element into float value
			        	float expect4 = Float.parseFloat(expected4);  
				        
			        	//Replace all commo's with empty space
			        	String expected5 = Utility.getReportProperty("Sale_Report_Percentage_Of_Sale").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Percentage_Of_Sale element into float value
			        	float expect5 = Float.parseFloat(expected5);   
				        
				        //Check weather the Sale Amount Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Sale_Amount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Category Sale reports are same for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Sale Amount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Sale Amount Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Sale Amount Value is : "+ actual);
				        }
				        
						else if(expect1 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Sale Amount
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();

				        	System.out.println("The Actual Sale Amount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Sale Amount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Category Sale reports are different for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the sale amount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        			        	
				        	//Get the different
				        	float different = actual - expect1;
				        	
				        	//Print the different value
				        	System.out.println("Sale Amount Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Sale Amount Value different is : "+different);	
				        }
				        
				        //Check weather the Quantity Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Quantity")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Category Sale reports are same for Quantity");
				        	
				        	//Get the Total value of Quantity
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Quantity Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Quantity Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Quantity Value is : "+ actual);
				        }
				        
						else if(expect2 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Quantity
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();

				        	System.out.println("The Actual Quantity value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Quantity value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Category Sale reports are different for Quantity");
				        	
				        	//Get the Total value of Quantity
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Quantity Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect2;
				        	
				        	//Print the different value
				        	System.out.println("Quantity Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Quantity Value different is : "+different);	
				        }
				        
				        
				        //Check weather the Tax Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Category Sale reports are same for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");   	

				        	//Convert the String value of the Tax Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Tax Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Tax Value is : "+ actual);
				        }
				        
						else if(expect3 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Tax
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();

				        	System.out.println("The Actual Tax value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Category Sale reports are different for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Tax Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect3;
				        	
				        	//Print the different value
				        	System.out.println("Tax Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Tax Value different is : "+different);	
				        }
				        
				        //Check weather the Discount Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Category Sale reports are same for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Discount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Discount Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Discount Value is : "+ actual);
				        }
				        
						else if(expect4 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Discount
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();

				        	System.out.println("The Actual Discount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Category Sale reports are different for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Discount Total element into float value
				        	float actual = Float.parseFloat(actualText);  	
				        	
				        	//Get the different
				        	float different = actual - expect4;
				        	
				        	//Print the different value
				        	System.out.println("Discount Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Discount Value different is : "+different);	
				        }
				        
				        //Check weather the Percentage Of Sale Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Percentage_Of_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Category Sale reports are same for Percentage Of Sale");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Percentage of Sale Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Percentage Of Sale Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Percentage Of Sale Value is : "+ actual);
				        }
				        
						else if(expect5 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Percentage Of Sale
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();

				        	System.out.println("The Actual Percentage Of Sale value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Percentage Of Sale value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Category Sale reports are different for Percentage Of Sale");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Percentage Of Sale Total element into float value
				        	float actual = Float.parseFloat(actualText);       		
				        	
				        	//Get the different
				        	float different = actual - expect5;
				        	
				        	//Print the different value
				        	System.out.println("Percentage Of Sale Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Percentage Of Sale Value different is : "+different);	
				        }
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for the Required Date Range");
					}
				}
			}

			@Test(priority=23,enabled = true)
			public void Category_Sale_method__Report_For_Specific_Date_WithOut_Quantity_Sort_With_Dynamic_Report(WebDriver driver) throws Exception
			{
				Thread.sleep(2000);
				WebElement html = driver.findElement(By.tagName("html"));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));

				Thread.sleep(3000);
				//Click the Category option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required Category
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				//Check whether the Quantity sort is enabled or not
				if(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']")).isSelected())
				{
					//Click the Quantity Sort option
					Actions act = new Actions(driver);
					act.moveToElement(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']/../span"))).click().build().perform();
				}
				else
				{
				}
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				for(int i = 1; i <= 8; i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}Thread.sleep(3000);
				
				//Check Whether all the field is selected or not
				if(driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'% of Sale')]/../input")).isSelected())
				{
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						//Check whether all the filed is available or not
						if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'% of Sale')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed())
						{
							test.log(LogStatus.PASS, "All the Neccessary fields are displayed");
						}
						else
						{
							test.log(LogStatus.FAIL, "Neccessary fields are not displayed");
						}
						
						//Change the option from enable to Disable the Sale Amount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected())
						{
							//Click the Enabled Sale Amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Sale Amount')]"))).click().build().perform();
							try
							{
								//Check whether the Sale Amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Sale Amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Sale Amount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Sale Amount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Quantity Option
						if(driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected())
						{
							//Click the Enabled Quantity Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Quantity')]"))).click().build().perform();
							try
							{
								//Check whether the Quantity Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Quantity is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Quantity is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Quantity Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Tax Option
						if(driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected())
						{
							//Click the Enabled Tax Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Tax')]"))).click().build().perform();
							try
							{
								//Check whether the Tax Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Tax is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Tax is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Tax Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Discount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
						{
							//Click the Enabled Discount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
							try
							{
								//Check whether the Discount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Discount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Discount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Discount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the % Of Sale Option
						if(driver.findElement(By.xpath("//span[contains(.,'% of Sale')]/../input")).isSelected())
						{
							//Click the Enabled % Of Sale Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'% of Sale')]"))).click().build().perform();
							try
							{
								//Check whether the % Of Sale Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'% of Sale')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "% Of Sale is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "% Of Sale is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "% Of Sale Option is Disabled When user enter the required date for date range");
						}
						
						//Enable the Sale Amount Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Sale Amount Option is Enabled after user click(Disable) the Sale Amount option");

						}
						else
						{
							//Click the Enabled Sale Amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Sale Amount')]"))).click().build().perform();
							try
							{
								//Check whether the Sale Amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Sale Amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Sale Amount is not displayed");
							}				}
						
						//Disable the required option from enable to disable Quantity Option
						if(driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Quantity Option is Enabled after user click(Disable) the Quantity option");
						}
						else
						{
							//Click the Enabled Quantity Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Quantity')]"))).click().build().perform();
							try
							{
								//Check whether the Quantity Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Quantity is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Quantity is not displayed");
							}

						}
						
						//Disable the required option from enable to disable Tax Option
						if(driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Tax Option is Enabled after user click(Disable) the Tax option");
						}
						else
						{

							//Click the Enabled Tax Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Tax')]"))).click().build().perform();
							try
							{
								//Check whether the Tax Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Tax is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Tax is not displayed");
							}

						}
						
						//Disable the required option from enable to disable Discount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Discount Option is Enabled after user click(Disable) the Discount option");

						}
						else
						{

							//Click the Enabled Discount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
							try
							{
								//Check whether the Discount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Discount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Discount is not displayed");
							}
						}
						
						//Disable the required option from enable to disable % Of Sale Option
						if(driver.findElement(By.xpath("//span[contains(.,'% of Sale')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "% Of Sale Option is Enabled after user click(Disable) the % of Sale option");

						}
						else
						{

							//Click the Enabled % Of Sale Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'% of Sale')]"))).click().build().perform();
							try
							{
								//Check whether the % Of Sale Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'% of Sale')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "% Of Sale is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "% Of Sale is not displayed");
							}
						}
		
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for the Required Date Range");
					}
					
				}
				else
				{
					test.log(LogStatus.FAIL, "All dynamic option is not selected");
				}
				
			}

			@Test(priority=24,enabled = true)
			public void Category_Sale_method__Report_For_Specific_Date_With_Quantity_Sort_And_Dynamic_Report(WebDriver driver) throws Exception
			{
				Thread.sleep(2000);
				WebElement html = driver.findElement(By.tagName("html"));
				html.sendKeys(Keys.HOME);

				Thread.sleep(3000);
				//Click the Category option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required Category
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				//Check whether the Quantity sort is enabled or not
				if(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']")).isSelected())
				{
					
				}
				else
				{
					//Click the Quantity Sort option
					Actions act = new Actions(driver);
					act.moveToElement(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']/../span"))).click().build().perform();
				}
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(2000);
				//Click the Run Button
				for(int i = 1; i <= 8; i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}Thread.sleep(3000);
				
				//Check Whether all the field is selected or not
				if(driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'% of Sale')]/../input")).isSelected())
				{
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						//Check whether all the filed is available or not
						if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'% of Sale')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed())
						{
							test.log(LogStatus.PASS, "All the Neccessary fields are displayed");
						}
						else
						{
							test.log(LogStatus.FAIL, "Neccessary fields are not displayed");
						}
						
						//Change the option from enable to Disable the Sale Amount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected())
						{
							//Click the Enabled Sale Amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Sale Amount')]"))).click().build().perform();
							try
							{
								//Check whether the Sale Amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Sale Amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Sale Amount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Sale Amount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Quantity Option
						if(driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected())
						{
							//Click the Enabled Quantity Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Quantity')]"))).click().build().perform();
							try
							{
								//Check whether the Quantity Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Quantity is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Quantity is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Quantity Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Tax Option
						if(driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected())
						{
							//Click the Enabled Tax Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Tax')]"))).click().build().perform();
							try
							{
								//Check whether the Tax Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Tax is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Tax is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Tax Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Discount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
						{
							//Click the Enabled Discount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
							try
							{
								//Check whether the Discount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Discount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Discount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Discount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the % Of Sale Option
						if(driver.findElement(By.xpath("//span[contains(.,'% of Sale')]/../input")).isSelected())
						{
							//Click the Enabled % Of Sale Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'% of Sale')]"))).click().build().perform();
							try
							{
								//Check whether the % Of Sale Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'% of Sale')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "% Of Sale is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "% Of Sale is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "% Of Sale Option is Disabled When user enter the required date for date range");
						}
						
						//Enable the Sale Amount Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Sale Amount Option is Enabled after user click(Disable) the Sale Amount option");

						}
						else
						{
							//Click the Enabled Sale Amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Sale Amount')]"))).click().build().perform();
							try
							{
								//Check whether the Sale Amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Sale Amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Sale Amount is not displayed");
							}				}
						
						//Disable the required option from enable to disable Quantity Option
						if(driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Quantity Option is Enabled after user click(Disable) the Quantity option");
						}
						else
						{
							//Click the Enabled Quantity Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Quantity')]"))).click().build().perform();
							try
							{
								//Check whether the Quantity Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Quantity is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Quantity is not displayed");
							}

						}
						
						//Disable the required option from enable to disable Tax Option
						if(driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Tax Option is Enabled after user click(Disable) the Tax option");
						}
						else
						{

							//Click the Enabled Tax Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Tax')]"))).click().build().perform();
							try
							{
								//Check whether the Tax Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Tax is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Tax is not displayed");
							}

						}
						
						//Disable the required option from enable to disable Discount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Discount Option is Enabled after user click(Disable) the Discount option");

						}
						else
						{

							//Click the Enabled Discount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
							try
							{
								//Check whether the Discount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Discount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Discount is not displayed");
							}
						}
						
						//Disable the required option from enable to disable % Of Sale Option
						if(driver.findElement(By.xpath("//span[contains(.,'% of Sale')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "% Of Sale Option is Enabled after user click(Disable) the % of Sale option");

						}
						else
						{

							//Click the Enabled % Of Sale Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'% of Sale')]"))).click().build().perform();
							try
							{
								//Check whether the % Of Sale Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'% of Sale')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "% Of Sale is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "% Of Sale is not displayed");
							}
						}
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for the Required Date Range");
					}
					
				}
				else
				{
					test.log(LogStatus.FAIL, "All dynamic option is not selected");
				}

			}
			
			@Test(priority=40,enabled = true)
			public void Sub_Category_Sale_method__OpenPageReport(WebDriver driver) throws Exception
			{
			/*	//Click the Reports option
				driver.findElement(By.xpath("//span[.='Reports']")).click();
				// Create instance of Java script executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath("//span[.='Sale']"));
				//Scroll the page till the Sale option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        //Click the Sale Option		
				driver.findElement(By.xpath("//span[.='Sale']")).click();*/
				
				Thread.sleep(3000);
				//Enter the Categories Url
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/subCategorySale");
				
				Thread.sleep(4000);
				
				//Check Sub Category Sale Report page opened or not
				if(driver.findElement(By.xpath("//label[.='Sub Category ']")).getText().equalsIgnoreCase("Sub Category"))
				{
					test.log(LogStatus.PASS, "Sub Category Sale report page loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Sub Category Sale report page loaded Failed");
				}
				
				Thread.sleep(3000);
			}
			
			@Test(priority=41,enabled = true)
			public void Sub_Category_Sale_method_For_Specific_Date(WebDriver driver) throws Exception
			{
				Thread.sleep(2000);
				WebElement html = driver.findElement(By.tagName("html"));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));

				Thread.sleep(3000);
				//Click the Category option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required Category
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				Thread.sleep(3000);
				//Click the Sub Category option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
				//Enter the required Sub Category
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);

				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				//Check whether the Quantity sort is enabled or not
				if(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']")).isSelected())
				{
					//Click the Quantity Sort option
					Actions act = new Actions(driver);
					act.moveToElement(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']/../span"))).click().build().perform();
				}
				else
				{}
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Sub Category Sale Report is not available for the Required Date Range");
				}
				else
				{
					test.log(LogStatus.PASS, "Sub Category Sale Report available for the Required Date Range");
					
					Thread.sleep(3000);
					//Check Weather the Top 5 sub category sale available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Here Top 5 Sub Category Sale Report available for the Required Date Range");
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);
						
						//Click the Pie chart option
						driver.findElement(By.xpath("//a[.='Pie']")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Pie Chart available");
						Thread.sleep(3000);
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);

						//Click the Polar Area chart option
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/ul/li[2]/a")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Polar Area Chart available");
						Thread.sleep(3000);
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);

						//Click the Bar chart option
						driver.findElement(By.xpath("//a[.='Bar']")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Bar Chart available");
						Thread.sleep(3000);
					}
					else
					{
						test.log(LogStatus.FAIL, "Here Top 5 Sub Category Sale Report not available for the Required Date Range");
					}
					
					Thread.sleep(3000);
					//Check weather the report graph is available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
					{
						test.log(LogStatus.PASS, "There is Graphical type of Sub category sale report is available for the Required Date Range");
					}
					else
					{
						test.log(LogStatus.FAIL, "Graphical report is not available for the Required Date Range");
					}
					
					Thread.sleep(3000);
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						Thread.sleep(3000);
				        //No.of rows
				        List<WebElement> rows = driver.findElements(By.xpath ("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
				        
		/*		        //Print number of Rows
				        System.out.println("Number of Rows are : "+rows);*/
				        
			        	//Replace all commo's with empty space
			        	String expected1 = Utility.getReportProperty("Sub_Category_Sale_Report_Sale_Amount").replace(",", "");
			        	
			        	//Convert the String value of the Sub_Category_Sale_Report_Sale_Amount element into float value
			        	float expect1 = Float.parseFloat(expected1);  
				        
			        	//Replace all commo's with empty space
			        	String expected2 = Utility.getReportProperty("Sub_Category_Sale_Report_Quantity").replace(",", "");
			        	
			        	//Convert the String value of the Sub_Category_Sale_Report_Sale_Quantity element into float value
			        	float expect2 = Float.parseFloat(expected2);  
				        
			        	//Replace all commo's with empty space
			        	String expected3 = Utility.getReportProperty("Sub_Category_Sale_Report_Tax").replace(",", "");
			        	
			        	//Convert the String value of the Sub_Category_Sale_Report_Tax element into float value
			        	float expect3 = Float.parseFloat(expected3);//System.out.println("TEST TAX AMOUNT IS : "+expected3);  
				        
			        	//Replace all commo's with empty space
			        	String expected4 = Utility.getReportProperty("Sub_Category_Sale_Report_Discount").replace(",", "");
			        	
			        	//Convert the String value of the Sub_Category_Sale_Report_Discount element into float value
			        	float expect4 = Float.parseFloat(expected4);   
				        
			        	//Replace all commo's with empty space
			        	String expected5 = Utility.getReportProperty("Sub_Category_Sale_Report_Percentage_Of_Sale").replace(",", "");
			        	
			        	//Convert the String value of the Sub_Category_Sale_Report_Percentage_Of_Sale element into float value
			        	float expect5 = Float.parseFloat(expected5);    
				        
				        //Check weather the Sale Amount Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText().equals(Utility.getReportProperty("Sub_Category_Sale_Report_Sale_Amount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sub Category Sale reports are same for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Sale Amount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Sale Amount Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Sale Amount Value is : "+ actual);
				        }
				        
						else if(expect1 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Sale Amount
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();

				        	System.out.println("The Actual Sale Amount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Sale Amount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sub Category Sale reports are different for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the sale amount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        			        	
				        	//Get the different
				        	float different = actual - expect1;
				        	
				        	//Print the different value
				        	System.out.println("Sale Amount Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Sale Amount Value different is : "+different);	
				        }
				        
				        //Check weather the Quantity Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sub_Category_Sale_Report_Quantity")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sub Category Sale reports are same for Quantity");
				        	
				        	//Get the Total value of Quantity
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Quantity Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Quantity Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Quantity Value is : "+ actual);
				        }
				        
						else if(expect2 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Quantity
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();

				        	System.out.println("The Actual Quantity value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Quantity value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sub Category Sale reports are different for Quantity");
				        	
				        	//Get the Total value of Quantity
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Quantity Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect2;
				        	
				        	//Print the different value
				        	System.out.println("Quantity Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Quantity Value different is : "+different);	
				        }
				        
				        //Check weather the Tax Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sub_Category_Sale_Report_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sub Category Sale reports are same for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");   	

				        	//Convert the String value of the Tax Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Tax Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Tax Value is : "+ actual);
				        }
				        
						else if(expect3 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Tax
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();

				        	System.out.println("The Actual Tax value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sub Category Sale reports are different for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Tax Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect3;
				        	
				        	//Print the different value
				        	System.out.println("Tax Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Tax Value different is : "+different);	
				        }
				        
				        //Check weather the Discount Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sub_Category_Sale_Report_Discount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sub Category Sale reports are same for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Discount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Discount Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Discount Value is : "+ actual);
				        }
				        
						else if(expect4 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Discount
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();

				        	System.out.println("The Actual Discount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sub Category Sale reports are different for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Discount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect4;
				        	
				        	//Print the different value
				        	System.out.println("Discount Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Discount Value different is : "+different);	
				        }
				        
				        //Check weather the Percentage Of Sale Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText().equals(Utility.getReportProperty("Sub_Category_Sale_Report_Percentage_Of_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sub Category Sale reports are same for Percentage Of Sale");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Percentage of Sale Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Percentage Of Sale Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Percentage Of Sale Value is : "+ actual);
				        }
				        
						else if(expect5 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Sale Amount
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();

				        	System.out.println("The Actual Percentage Of Sale value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Percentage Of Sale value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sub Category Sale reports are different for Percentage Of Sale");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Percentage Of Sale Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect5;
				        	
				        	//Print the different value
				        	System.out.println("Percentage Of Sale Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Percentage Of Sale Value different is : "+different);	
				        }
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for the Required Date Range");
					}
				}
			}
			
			@Test(priority=42,enabled = true)
			public void Sub_Category_Sale_method_For_Specific_Date_With_Quantity_Sort(WebDriver driver) throws Exception
			{
				Thread.sleep(2000);
				WebElement html = driver.findElement(By.tagName("html"));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));

				Thread.sleep(3000);
				//Click the Category option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required Category
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				Thread.sleep(3000);
				//Click the Sub Category option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
				//Enter the required Sub Category
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);

				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				//Check whether the Quantity sort is enabled or not
				if(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']")).isSelected())
				{
					
				}
				else
				{
					//Click the Quantity Sort option
					Actions act = new Actions(driver);
					act.moveToElement(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']/../span"))).click().build().perform();
				}
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Number of rows
				List<WebElement> rowss = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
				int rowa = rowss.size()-1;
				ArrayList<Integer> array = new ArrayList<Integer>();
				for(int i =1; i <= rowa; i++)
				{
					String quan = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+i+"]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
					Integer dquan = Integer.parseInt(quan);
					//int quantity = quan.intValue();
					array.add(dquan);
				}
				Collections.sort(array);
				for(int i =0; i < rowa; i++)
				{	int s = i+1;
					String e = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+s+"]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
					double actual = Double.parseDouble(e);
					double expect = array.get(i);
					if(actual != expect)
					{
						test.log(LogStatus.PASS, "Sorted by Quantity is Fail");
					}
				}
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Sub Category Sale Report is not available for the Required Date Range");
				}
				else
				{
					test.log(LogStatus.PASS, "Sub Category Sale Report available for the Required Date Range");
					
					Thread.sleep(3000);
					//Check Weather the Top 5 sub category sale available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Here Top 5 Sub Category Sale Report available for the Required Date Range");
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);
						
						//Click the Pie chart option
						driver.findElement(By.xpath("//a[.='Pie']")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Pie Chart available");
						Thread.sleep(3000);
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);

						//Click the Polar Area chart option
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/ul/li[2]/a")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Polar Area Chart available");
						Thread.sleep(3000);
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);

						//Click the Bar chart option
						driver.findElement(By.xpath("//a[.='Bar']")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Bar Chart available");
						Thread.sleep(3000);
					}
					else
					{
						test.log(LogStatus.FAIL, "Here Top 5 Sub Category Sale Report not available for the Required Date Range");
					}
					
					Thread.sleep(3000);
					//Check weather the report graph is available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
					{
						test.log(LogStatus.PASS, "There is Graphical type of Sub category sale report is available for the Required Date Range");
					}
					else
					{
						test.log(LogStatus.FAIL, "Graphical report is not available for the Required Date Range");
					}
					
					Thread.sleep(3000);
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						Thread.sleep(3000);
				        //No.of rows
				        List<WebElement> rows = driver.findElements(By.xpath ("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
				        
		/*		        //Print number of Rows
				        System.out.println("Number of Rows are : "+rows);*/
				        
			        	//Replace all commo's with empty space
			        	String expected1 = Utility.getReportProperty("Sub_Category_Sale_Report_Sale_Amount").replace(",", "");
			        	
			        	//Convert the String value of the Sub_Category_Sale_Report_Sale_Amount element into float value
			        	float expect1 = Float.parseFloat(expected1);  
				        
			        	//Replace all commo's with empty space
			        	String expected2 = Utility.getReportProperty("Sub_Category_Sale_Report_Quantity").replace(",", "");
			        	
			        	//Convert the String value of the Sub_Category_Sale_Report_Sale_Quantity element into float value
			        	float expect2 = Float.parseFloat(expected2);  
				        
			        	//Replace all commo's with empty space
			        	String expected3 = Utility.getReportProperty("Sub_Category_Sale_Report_Tax").replace(",", "");
			        	
			        	//Convert the String value of the Sub_Category_Sale_Report_Tax element into float value
			        	float expect3 = Float.parseFloat(expected3);  
				        
			        	//Replace all commo's with empty space
			        	String expected4 = Utility.getReportProperty("Sub_Category_Sale_Report_Discount").replace(",", "");
			        	
			        	//Convert the String value of the Sub_Category_Sale_Report_Discount element into float value
			        	float expect4 = Float.parseFloat(expected4);   
				        
			        	//Replace all commo's with empty space
			        	String expected5 = Utility.getReportProperty("Sub_Category_Sale_Report_Percentage_Of_Sale").replace(",", "");
			        	
			        	//Convert the String value of the Sub_Category_Sale_Report_Percentage_Of_Sale element into float value
			        	float expect5 = Float.parseFloat(expected5);    
				        
				        //Check weather the Sale Amount Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText().equals(Utility.getReportProperty("Sub_Category_Sale_Report_Sale_Amount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sub Category Sale reports are same for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Sale Amount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Sale Amount Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Sale Amount Value is : "+ actual);
				        }
				        
						else if(expect1 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Sale Amount
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();

				        	System.out.println("The Actual Sale Amount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Sale Amount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sub Category Sale reports are different for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the sale amount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        			        	
				        	//Get the different
				        	float different = actual - expect1;
				        	
				        	//Print the different value
				        	System.out.println("Sale Amount Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Sale Amount Value different is : "+different);	
				        }
				        
				        //Check weather the Quantity Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sub_Category_Sale_Report_Quantity")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sub Category Sale reports are same for Quantity");
				        	
				        	//Get the Total value of Quantity
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Quantity Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Quantity Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Quantity Value is : "+ actual);
				        }
				        
						else if(expect2 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Quantity
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();

				        	System.out.println("The Actual Quantity value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Quantity value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sub Category Sale reports are different for Quantity");
				        	
				        	//Get the Total value of Quantity
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Quantity Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect2;
				        	
				        	//Print the different value
				        	System.out.println("Quantity Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Quantity Value different is : "+different);	
				        }
				        
				        //Check weather the Tax Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sub_Category_Sale_Report_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sub Category Sale reports are same for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");   	

				        	//Convert the String value of the Tax Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Tax Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Tax Value is : "+ actual);
				        }
				        
						else if(expect3 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Tax
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();

				        	System.out.println("The Actual Tax value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sub Category Sale reports are different for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Tax Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect3;
				        	
				        	//Print the different value
				        	System.out.println("Tax Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Tax Value different is : "+different);	
				        }
				        
				        //Check weather the Discount Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sub_Category_Sale_Report_Discount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sub Category Sale reports are same for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Discount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Discount Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Discount Value is : "+ actual);
				        }
				        
						else if(expect4 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Discount
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();

				        	System.out.println("The Actual Discount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sub Category Sale reports are different for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Discount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect4;
				        	
				        	//Print the different value
				        	System.out.println("Discount Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Discount Value different is : "+different);	
				        }
				        
				        //Check weather the Percentage Of Sale Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText().equals(Utility.getReportProperty("Sub_Category_Sale_Report_Percentage_Of_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sub Category Sale reports are same for Percentage Of Sale");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Percentage of Sale Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Percentage Of Sale Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Percentage Of Sale Value is : "+ actual);
				        }
				        
						else if(expect5 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Sale Amount
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();

				        	System.out.println("The Actual Percentage Of Sale value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Percentage Of Sale value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sub Category Sale reports are different for Percentage Of Sale");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Percentage Of Sale Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect5;
				        	
				        	//Print the different value
				        	System.out.println("Percentage Of Sale Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Percentage Of Sale Value different is : "+different);	
				        }
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for the Required Date Range");
					}
				}
			}
			
			@Test(priority=43,enabled = true)
			public void Sub_Category_Sale_method_For_Specific_Date_WithOut_Quantity_Sort_With_Dynamic_Report(WebDriver driver) throws Exception
			{
				Thread.sleep(2000);
				WebElement html = driver.findElement(By.tagName("html"));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));

				Thread.sleep(3000);
				//Click the Category option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required Category
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				Thread.sleep(3000);
				//Click the Sub Category option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
				//Enter the required Sub Category
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);

				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				//Check whether the Quantity sort is enabled or not
				if(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']")).isSelected())
				{
					//Click the Quantity Sort option
					Actions act = new Actions(driver);
					act.moveToElement(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']/../span"))).click().build().perform();
				}
				else
				{}
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				for(int i = 1; i <= 8; i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}Thread.sleep(3000);
				
				//Check Whether all the field is selected or not
				if(driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'% of Sale')]/../input")).isSelected())
				{
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						//Check whether all the filed is available or not
						if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'% of Sale')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed())
						{
							test.log(LogStatus.PASS, "All the Neccessary fields are displayed");
						}
						else
						{
							test.log(LogStatus.FAIL, "Neccessary fields are not displayed");
						}
						
						//Change the option from enable to Disable the Sale Amount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected())
						{
							//Click the Enabled Sale Amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Sale Amount')]"))).click().build().perform();
							try
							{
								//Check whether the Sale Amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Sale Amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Sale Amount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Sale Amount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Quantity Option
						if(driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected())
						{
							//Click the Enabled Quantity Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Quantity')]"))).click().build().perform();
							try
							{
								//Check whether the Quantity Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Quantity is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Quantity is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Quantity Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Tax Option
						if(driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected())
						{
							//Click the Enabled Tax Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Tax')]"))).click().build().perform();
							try
							{
								//Check whether the Tax Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Tax is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Tax is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Tax Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Discount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
						{
							//Click the Enabled Discount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
							try
							{
								//Check whether the Discount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Discount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Discount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Discount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the % Of Sale Option
						if(driver.findElement(By.xpath("//span[contains(.,'% of Sale')]/../input")).isSelected())
						{
							//Click the Enabled % Of Sale Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'% of Sale')]"))).click().build().perform();
							try
							{
								//Check whether the % Of Sale Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'% of Sale')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "% Of Sale is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "% Of Sale is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "% Of Sale Option is Disabled When user enter the required date for date range");
						}
						
						//Enable the Sale Amount Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Sale Amount Option is Enabled after user click(Disable) the Sale Amount option");

						}
						else
						{
							//Click the Enabled Sale Amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Sale Amount')]"))).click().build().perform();
							try
							{
								//Check whether the Sale Amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Sale Amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Sale Amount is not displayed");
							}				}
						
						//Disable the required option from enable to disable Quantity Option
						if(driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Quantity Option is Enabled after user click(Disable) the Quantity option");
						}
						else
						{
							//Click the Enabled Quantity Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Quantity')]"))).click().build().perform();
							try
							{
								//Check whether the Quantity Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Quantity is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Quantity is not displayed");
							}

						}
						
						//Disable the required option from enable to disable Tax Option
						if(driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Tax Option is Enabled after user click(Disable) the Tax option");
						}
						else
						{

							//Click the Enabled Tax Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Tax')]"))).click().build().perform();
							try
							{
								//Check whether the Tax Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Tax is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Tax is not displayed");
							}

						}
						
						//Disable the required option from enable to disable Discount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Discount Option is Enabled after user click(Disable) the Discount option");

						}
						else
						{

							//Click the Enabled Discount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
							try
							{
								//Check whether the Discount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Discount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Discount is not displayed");
							}
						}
						
						//Disable the required option from enable to disable % Of Sale Option
						if(driver.findElement(By.xpath("//span[contains(.,'% of Sale')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "% Of Sale Option is Enabled after user click(Disable) the % of Sale option");

						}
						else
						{

							//Click the Enabled % Of Sale Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'% of Sale')]"))).click().build().perform();
							try
							{
								//Check whether the % Of Sale Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'% of Sale')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "% Of Sale is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "% Of Sale is not displayed");
							}
						}
		
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for the Required Date Range");
					}
					
				}
				else
				{
					test.log(LogStatus.FAIL, "All dynamic option is not selected");
				}
			}
			
			@Test(priority=44,enabled = true)
			public void Sub_Category_Sale_method_For_Specific_Date_With_Quantity_And_With_Dynamic_Report(WebDriver driver) throws Exception
			{
				Thread.sleep(2000);
				WebElement html = driver.findElement(By.tagName("html"));
				html.sendKeys(Keys.HOME);

				Thread.sleep(3000);
				//Click the Category option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required Category
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				Thread.sleep(3000);
				//Click the Sub Category option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
				//Enter the required Sub Category
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);

				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				//Check whether the Quantity sort is enabled or not
				if(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']")).isSelected())
				{
					
				}
				else
				{
					//Click the Quantity Sort option
					Actions act = new Actions(driver);
					act.moveToElement(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']/../span"))).click().build().perform();
				}
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();Thread.sleep(3000);
				for(int i = 1; i <= 8; i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}Thread.sleep(3000);
				
				//Check Whether all the field is selected or not
				if(driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'% of Sale')]/../input")).isSelected())
				{
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						//Check whether all the filed is available or not
						if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'% of Sale')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed())
						{
							test.log(LogStatus.PASS, "All the Neccessary fields are displayed");
						}
						else
						{
							test.log(LogStatus.FAIL, "Neccessary fields are not displayed");
						}
						
						//Change the option from enable to Disable the Sale Amount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected())
						{
							//Click the Enabled Sale Amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Sale Amount')]"))).click().build().perform();
							try
							{
								//Check whether the Sale Amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Sale Amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Sale Amount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Sale Amount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Quantity Option
						if(driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected())
						{
							//Click the Enabled Quantity Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Quantity')]"))).click().build().perform();
							try
							{
								//Check whether the Quantity Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Quantity is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Quantity is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Quantity Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Tax Option
						if(driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected())
						{
							//Click the Enabled Tax Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Tax')]"))).click().build().perform();
							try
							{
								//Check whether the Tax Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Tax is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Tax is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Tax Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Discount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
						{
							//Click the Enabled Discount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
							try
							{
								//Check whether the Discount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Discount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Discount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Discount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the % Of Sale Option
						if(driver.findElement(By.xpath("//span[contains(.,'% of Sale')]/../input")).isSelected())
						{
							//Click the Enabled % Of Sale Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'% of Sale')]"))).click().build().perform();
							try
							{
								//Check whether the % Of Sale Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'% of Sale')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "% Of Sale is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "% Of Sale is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "% Of Sale Option is Disabled When user enter the required date for date range");
						}
		
						//Enable the Sale Amount Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Sale Amount Option is Enabled after user click(Disable) the Sale Amount option");

						}
						else
						{
							//Click the Enabled Sale Amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Sale Amount')]"))).click().build().perform();
							try
							{
								//Check whether the Sale Amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Sale Amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Sale Amount is not displayed");
							}				
						}
						
						//Disable the required option from enable to disable Quantity Option
						if(driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Quantity Option is Enabled after user click(Disable) the Quantity option");
						}
						else
						{
							//Click the Enabled Quantity Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Quantity')]"))).click().build().perform();
							try
							{
								//Check whether the Quantity Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Quantity is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Quantity is not displayed");
							}

						}
						
						//Disable the required option from enable to disable Tax Option
						if(driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Tax Option is Enabled after user click(Disable) the Tax option");
						}
						else
						{

							//Click the Enabled Tax Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Tax')]"))).click().build().perform();
							try
							{
								//Check whether the Tax Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Tax is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Tax is not displayed");
							}

						}
						
						//Disable the required option from enable to disable Discount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Discount Option is Enabled after user click(Disable) the Discount option");

						}
						else
						{

							//Click the Enabled Discount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
							try
							{
								//Check whether the Discount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Discount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Discount is not displayed");
							}
						}
						
						//Disable the required option from enable to disable % Of Sale Option
						if(driver.findElement(By.xpath("//span[contains(.,'% of Sale')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "% Of Sale Option is Enabled after user click(Disable) the % of Sale option");

						}
						else
						{

							//Click the Enabled % Of Sale Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'% of Sale')]"))).click().build().perform();
							try
							{
								//Check whether the % Of Sale Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'% of Sale')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "% Of Sale is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "% Of Sale is not displayed");
							}
						}
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for the Required Date Range");
					}
					
				}
				else
				{
					test.log(LogStatus.FAIL, "All dynamic option is not selected");
				}

			}

			@Test(priority=60,enabled = true)
			public void Menu_Item_Sale_method_openpage_Report(WebDriver driver) throws Exception
			{
				/*//Click the Reports option
				driver.findElement(By.xpath("//span[.='Reports']")).click();
				// Create instance of Java script executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath("//span[.='Sale']"));
				//Scroll the page till the Sale option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        //Click the Sale Option		
				driver.findElement(By.xpath("//span[.='Sale']")).click();*/
				
				Thread.sleep(3000);
				//Enter the Categories Url
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/menuItemSale");
				
				
				Thread.sleep(3000);
				
				//Check Menu Item Sale Report page opened or not
				if(driver.findElement(By.xpath("//label[.='Menu Item']")).getText().equalsIgnoreCase("Menu Item"))
				{
					test.log(LogStatus.PASS, "Menu Item Sale report page loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Menu Item Sale report page loaded Failed");
				}
				
				Thread.sleep(3000);
			}
			
			@Test(priority=61,enabled = true)
			public void Menu_Item_Sale_method__Report_For_Specific_Date(WebDriver driver) throws Exception
			{
				Thread.sleep(2000);
				WebElement html = driver.findElement(By.tagName("html"));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));

				Thread.sleep(3000);
				//Click the Category option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required Category
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				Thread.sleep(3000);
				//Click the Sub Category option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
				//Enter the required Sub Category
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);

				Thread.sleep(3000);
				//Click the Menu Item option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/a")).click();
				//Enter the required Menu Item
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(3000);
				//Click the Serving Level option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/a")).click();
				//Enter the required Serving Level
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				//Check Whether the Split By Serving Size Level is enabled or not
				if(driver.findElement(By.xpath("//input[@ng-model='query.splitBySS']")).isSelected())
				{
					Thread.sleep(2000);
					//Change the option from enable to Disable the Split by Serving Level
					Actions act = new Actions(driver);
					act.moveToElement(driver.findElement(By.xpath("//input[@ng-model='query.splitBySS']/../span"))).click().build().perform();
				}

				
				Thread.sleep(3000);
				//Click the Employee option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[6]/div/div/a")).click();
				//Enter the required Employee
				driver.findElement(By.xpath("//form[@name='saleReport']/div[6]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);

				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[7]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[7]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[8]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[8]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[8]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[8]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				//Check whether the Quantity sort is enabled or not
				if(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']")).isSelected())
				{
					//Click the Quantity Sort option
					Actions act = new Actions(driver);
					act.moveToElement(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']/../span"))).click().build().perform();
				}
				else
				{
				}
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Menu Item Sale Report is not available for the Required Date Range");
				}
				else
				{
					test.log(LogStatus.PASS, "Menu Item Sale Report available for the Required Date Range");
					
					Thread.sleep(3000);
					//Check Weather the Top 5 menu Item sale available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Here Top 5 menu item Sale Report available for the Required Date Range");
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);
						
						//Click the Pie chart option
						driver.findElement(By.xpath("//a[.='Pie']")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Pie Chart available");
						Thread.sleep(3000);
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);

						//Click the Polar Area chart option
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/ul/li[2]/a")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Polar Area Chart available");
						Thread.sleep(3000);
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);

						//Click the Bar chart option
						driver.findElement(By.xpath("//a[.='Bar']")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Bar Chart available");
						Thread.sleep(3000);
					}
					else
					{
						test.log(LogStatus.FAIL, "Here Top 5 menu item Sale Report not available for the Required Date Range");
					}
					
					Thread.sleep(3000);
					//Check weather the report graph is available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
					{
						test.log(LogStatus.PASS, "There is Graphical type of menu item sale report is available for the Required Date Range");
					}
					else
					{
						test.log(LogStatus.FAIL, "Graphical report is not available for the Required Date Range");
					}
					
					Thread.sleep(3000);
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						Thread.sleep(3000);
				        //No.of rows
				        List<WebElement> rows = driver.findElements(By.xpath ("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
				        
		/*		        //Print number of Rows
				        System.out.println("Number of Rows are : "+rows);*/
				        
			        	//Replace all commo's with empty space
			        	String expected1 = Utility.getReportProperty("Sale_Report_Sale_Amount").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Sale_Amount element into float value
			        	float expect1 = Float.parseFloat(expected1);  
			        	
			        	//Replace all commo's with empty space
			        	String expected2 = Utility.getReportProperty("Sale_Report_Quantity").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Quantity element into float value
			        	float expect2 = Float.parseFloat(expected2); 
			        	
			        	//Replace all commo's with empty space
			        	String expected3 = Utility.getReportProperty("Sale_Report_Tax").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Tax element into float value
			        	float expect3 = Float.parseFloat(expected3);  
			        	
			        	//Replace all commo's with empty space
			        	String expected4 = Utility.getReportProperty("Sale_Report_Discount").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Discount element into float value
			        	float expect4 = Float.parseFloat(expected4);    
				        
			        	//Replace all commo's with empty space
			        	String expected5 = Utility.getReportProperty("Sale_Report_Percentage_Of_Sale").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Percentage_Of_Sale element into float value
			        	float expect5 = Float.parseFloat(expected5);     
			        	
				        //Check weather the Sale Amount Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Sale_Amount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected menu item Sale reports are same for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Sale Amount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Sale Amount Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Sale Amount Value is : "+ actual);
				        }
				        
						else if(expect1 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Sale Amount
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();

				        	System.out.println("The Actual Sale Amount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Sale Amount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected menu item Sale reports are different for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the sale amount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        			        	
				        	//Get the different
				        	float different = actual - expect1;
				        	
				        	//Print the different value
				        	System.out.println("Sale Amount Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Sale Amount Value different is : "+different);	
				        }
				        
				        //Check weather the Quantity Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Quantity")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected menu item Sale reports are same for Quantity");
				        	
				        	//Get the Total value of Quantity
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Quantity Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Quantity Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Quantity Value is : "+ actual);
				        }
				        
						else if(expect2 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Quantity
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();

				        	System.out.println("The Actual Quantity value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Quantity value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected menu item Sale reports are different for Quantity");
				        	
				        	//Get the Total value of Quantity
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Quantity Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect2;
				        	
				        	//Print the different value
				        	System.out.println("Quantity Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Quantity Value different is : "+different);	
				        }
				        
				        //Check weather the Tax Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected menu item Sale reports are same for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");   	

				        	//Convert the String value of the Tax Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Tax Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Tax Value is : "+ actual);
				        }
				        
						else if(expect3 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Sale Amount
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();

				        	System.out.println("The Actual Tax value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected menu item Sale reports are different for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Tax Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect3;
				        	
				        	//Print the different value
				        	System.out.println("Tax Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Tax Value different is : "+different);	
				        }
				        
				        //Check weather the Discount Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected menu item Sale reports are same for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Discount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Discount Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Discount Value is : "+ actual);
				        }
				        
						else if(expect4 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Sale Amount
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();

				        	System.out.println("The Actual Discount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected menu item Sale reports are different for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Discount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect4;
				        	
				        	//Print the different value
				        	System.out.println("Discount Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Discount Value different is : "+different);	
				        }
				        
				        //Check weather the Percentage Of Sale Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Percentage_Of_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected menu item Sale reports are same for Percentage Of Sale");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Percentage of Sale Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
				        }
				        
						else if(expect5 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Percentage of Sale
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();

				        	System.out.println("The Actual Percentage Of Sale value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Percentage Of Sale value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected menu item Sale reports are different for Percentage Of Sale");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Percentage Of Sale Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect5;
				        	
				        	//Print the different value
				        	System.out.println("Percentage Of Sale Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Percentage Of Sale Value different is : "+different);	
				        }
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for the Required Date Range");
					}
				}
			}

			@Test(priority=62,enabled = true)
			public void Menu_Item_Sale_method__Report_For_Specific_Date_With_Quantity_Sort(WebDriver driver) throws Exception
			{
				Thread.sleep(2000);
				WebElement html = driver.findElement(By.tagName("html"));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));

				Thread.sleep(3000);
				//Click the Category option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required Category
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				Thread.sleep(3000);
				//Click the Sub Category option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
				//Enter the required Sub Category
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);

				Thread.sleep(3000);
				//Click the Menu Item option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/a")).click();
				//Enter the required Menu Item
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(3000);
				//Click the Serving Level option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/a")).click();
				//Enter the required Serving Level
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				//Check whether the split by serving size is enabled or not
				if(driver.findElement(By.xpath("//input[@ng-model='query.splitBySS']")).isSelected())
				{}
				else
				{
					Thread.sleep(2000);
					//Enable the Split by Serving Level
					Actions act = new Actions(driver);
					act.moveToElement(driver.findElement(By.xpath("//input[@ng-model='query.splitBySS']/../span"))).click().build().perform();
					//driver.findElement(By.xpath("//input[@ng-model='query.splitBySS']/../span")).click();
				}				
				Thread.sleep(3000);
				//Click the Employee option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[6]/div/div/a")).click();
				//Enter the required Employee
				driver.findElement(By.xpath("//form[@name='saleReport']/div[6]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);

				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[7]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[7]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[8]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[8]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[8]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[8]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				//Check whether the Quantity sort is enabled or not
				if(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']")).isSelected())
				{
					
				}
				else
				{
					//Click the Quantity Sort option
					Actions act = new Actions(driver);
					act.moveToElement(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']/../span"))).click().build().perform();
				}
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Number of rows
				List<WebElement> rowss = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr"));
				int rowa = rowss.size()-1;
				ArrayList<Integer> array = new ArrayList<Integer>();
				for(int i =1; i <= rowa; i++)
				{
					String quan = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr["+i+"]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
					Integer dquan = Integer.parseInt(quan);
					//int quantity = quan.intValue();
					array.add(dquan);
				}
				Collections.sort(array);
				for(int i =0; i < rowa; i++)
				{	int s = i+1;
					String e = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr["+s+"]/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
					double actual = Double.parseDouble(e);
					double expect = array.get(i);
					if(actual != expect)
					{
						test.log(LogStatus.PASS, "Sorted by Quantity is Fail");
					}
				}
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Menu Item Sale Report is not available for the Required Date Range");
				}
				else
				{
					test.log(LogStatus.PASS, "Menu Item Sale Report available for the Required Date Range");
					
					Thread.sleep(3000);
					//Check Weather the Top 5 menu Item sale available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Here Top 5 menu item Sale Report available for the Required Date Range");
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);
						
						//Click the Pie chart option
						driver.findElement(By.xpath("//a[.='Pie']")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Pie Chart available");
						Thread.sleep(3000);
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);

						//Click the Polar Area chart option
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/ul/li[2]/a")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Polar Area Chart available");
						Thread.sleep(3000);
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);

						//Click the Bar chart option
						driver.findElement(By.xpath("//a[.='Bar']")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Bar Chart available");
						Thread.sleep(3000);
					}
					else
					{
						test.log(LogStatus.FAIL, "Here Top 5 menu item Sale Report not available for the Required Date Range");
					}
					
					Thread.sleep(3000);
					//Check weather the report graph is available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
					{
						test.log(LogStatus.PASS, "There is Graphical type of menu item sale report is available for the Required Date Range");
					}
					else
					{
						test.log(LogStatus.FAIL, "Graphical report is not available for the Required Date Range");
					}
					
					Thread.sleep(3000);
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						Thread.sleep(3000);
				        //No.of rows
				        List<WebElement> rows = driver.findElements(By.xpath ("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
				        
		/*		        //Print number of Rows
				        System.out.println("Number of Rows are : "+rows);*/
				        
			        	//Replace all commo's with empty space
			        	String expected1 = Utility.getReportProperty("Sale_Report_Sale_Amount").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Sale_Amount element into float value
			        	float expect1 = Float.parseFloat(expected1);  
			        	
			        	//Replace all commo's with empty space
			        	String expected2 = Utility.getReportProperty("Sale_Report_Quantity").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Quantity element into float value
			        	float expect2 = Float.parseFloat(expected2); 
			        	
			        	//Replace all commo's with empty space
			        	String expected3 = Utility.getReportProperty("Sale_Report_Tax").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Tax element into float value
			        	float expect3 = Float.parseFloat(expected3);  
			        	
			        	//Replace all commo's with empty space
			        	String expected4 = Utility.getReportProperty("Sale_Report_Discount").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Discount element into float value
			        	float expect4 = Float.parseFloat(expected4);    
				        
			        	//Replace all commo's with empty space
			        	String expected5 = Utility.getReportProperty("Sale_Report_Percentage_Of_Sale").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Percentage_Of_Sale element into float value
			        	float expect5 = Float.parseFloat(expected5);     
			        	
				        //Check weather the Sale Amount Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Sale_Amount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected menu item Sale reports are same for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Sale Amount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Sale Amount Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Sale Amount Value is : "+ actual);
				        }
				        
						else if(expect1 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Sale Amount
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();

				        	System.out.println("The Actual Sale Amount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Sale Amount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected menu item Sale reports are different for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the sale amount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        			        	
				        	//Get the different
				        	float different = actual - expect1;
				        	
				        	//Print the different value
				        	System.out.println("Sale Amount Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Sale Amount Value different is : "+different);	
				        }
				        
				        //Check weather the Quantity Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Quantity")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected menu item Sale reports are same for Quantity");
				        	
				        	//Get the Total value of Quantity
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Quantity Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Quantity Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Quantity Value is : "+ actual);
				        }
				        
						else if(expect2 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Quantity
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();

				        	System.out.println("The Actual Quantity value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Quantity value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected menu item Sale reports are different for Quantity");
				        	
				        	//Get the Total value of Quantity
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Quantity Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect2;
				        	
				        	//Print the different value
				        	System.out.println("Quantity Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Quantity Value different is : "+different);	
				        }
				        
				        //Check weather the Tax Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected menu item Sale reports are same for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");   	

				        	//Convert the String value of the Tax Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Tax Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Tax Value is : "+ actual);
				        }
				        
						else if(expect3 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Sale Amount
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();

				        	System.out.println("The Actual Tax value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected menu item Sale reports are different for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Tax Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect3;
				        	
				        	//Print the different value
				        	System.out.println("Tax Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Tax Value different is : "+different);	
				        }
				        
				        //Check weather the Discount Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected menu item Sale reports are same for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Discount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Discount Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Discount Value is : "+ actual);
				        }
				        
						else if(expect4 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Sale Amount
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();

				        	System.out.println("The Actual Discount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected menu item Sale reports are different for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Discount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect4;
				        	
				        	//Print the different value
				        	System.out.println("Discount Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Discount Value different is : "+different);	
				        }
				        
				        //Check weather the Percentage Of Sale Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Percentage_Of_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected menu item Sale reports are same for Percentage Of Sale");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Percentage of Sale Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Value is : "+ actual);
				        }
				        
						else if(expect5 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Percentage of Sale
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();

				        	System.out.println("The Actual Percentage Of Sale value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Percentage Of Sale value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected menu item Sale reports are different for Percentage Of Sale");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Percentage Of Sale Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect5;
				        	
				        	//Print the different value
				        	System.out.println("Percentage Of Sale Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Percentage Of Sale Value different is : "+different);	
				        }
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for the Required Date Range");
					}
				}
			}

			@Test(priority=63,enabled = true)
			public void Menu_Item_Sale_method__Report_For_Specific_Date_With_Dynamic_Report_Without_Quantity_Sort(WebDriver driver) throws Exception
			{
				Thread.sleep(2000);
				WebElement html = driver.findElement(By.tagName("html"));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));

				Thread.sleep(3000);
				//Click the Category option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required Category
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				Thread.sleep(3000);
				//Click the Sub Category option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
				//Enter the required Sub Category
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);

				Thread.sleep(3000);
				//Click the Menu Item option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/a")).click();
				//Enter the required Menu Item
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(3000);
				//Click the Serving Level option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/a")).click();
				//Enter the required Serving Level
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				//Check Whether the Split By Serving Size Level is enabled or not
				if(driver.findElement(By.xpath("//input[@ng-model='query.splitBySS']")).isSelected())
				{
					Thread.sleep(2000);
					//Change the option from enable to Disable the Split by Serving Level
					Actions act = new Actions(driver);
					act.moveToElement(driver.findElement(By.xpath("//input[@ng-model='query.splitBySS']/../span"))).click().build().perform();
				}

				
				Thread.sleep(3000);
				//Click the Employee option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[6]/div/div/a")).click();
				//Enter the required Employee
				driver.findElement(By.xpath("//form[@name='saleReport']/div[6]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);

				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[7]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[7]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[8]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[8]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[8]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[8]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				//Check whether the Quantity sort is enabled or not
				if(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']")).isSelected())
				{
					//Click the Quantity Sort option
					Actions act = new Actions(driver);
					act.moveToElement(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']/../span"))).click().build().perform();
				}
				else
				{
				}
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				for(int i = 1; i <= 8; i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}Thread.sleep(3000);
				//Check Whether all the field is selected or not
				if(driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'% of Sale')]/../input")).isSelected())
				{
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						//Check whether all the filed is available or not
						if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'% of Sale')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed())
						{
							test.log(LogStatus.PASS, "All the Neccessary fields are displayed");
						}
						else
						{
							test.log(LogStatus.FAIL, "Neccessary fields are not displayed");
						}
						
						//Change the option from enable to Disable the Sale Amount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected())
						{
							//Click the Enabled Sale Amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Sale Amount')]"))).click().build().perform();
							try
							{
								//Check whether the Sale Amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Sale Amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Sale Amount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Sale Amount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Quantity Option
						if(driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected())
						{
							//Click the Enabled Quantity Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Quantity')]"))).click().build().perform();
							try
							{
								//Check whether the Quantity Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Quantity is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Quantity is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Quantity Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Tax Option
						if(driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected())
						{
							//Click the Enabled Tax Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Tax')]"))).click().build().perform();
							try
							{
								//Check whether the Tax Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Tax is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Tax is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Tax Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Discount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
						{
							//Click the Enabled Discount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
							try
							{
								//Check whether the Discount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Discount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Discount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Discount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the % Of Sale Option
						if(driver.findElement(By.xpath("//span[contains(.,'% of Sale')]/../input")).isSelected())
						{
							//Click the Enabled % Of Sale Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'% of Sale')]"))).click().build().perform();
							try
							{
								//Check whether the % Of Sale Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'% of Sale')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "% Of Sale is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "% Of Sale is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "% Of Sale Option is Disabled When user enter the required date for date range");
						}
						
						//Enable the Sale Amount Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Sale Amount Option is Enabled after user click(Disable) the Sale Amount option");

						}
						else
						{
							//Click the Enabled Sale Amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Sale Amount')]"))).click().build().perform();
							try
							{
								//Check whether the Sale Amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Sale Amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Sale Amount is not displayed");
							}				}
						
						//Disable the required option from enable to disable Quantity Option
						if(driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Quantity Option is Enabled after user click(Disable) the Quantity option");
						}
						else
						{
							//Click the Enabled Quantity Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Quantity')]"))).click().build().perform();
							try
							{
								//Check whether the Quantity Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Quantity is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Quantity is not displayed");
							}

						}
						
						//Disable the required option from enable to disable Tax Option
						if(driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Tax Option is Enabled after user click(Disable) the Tax option");
						}
						else
						{

							//Click the Enabled Tax Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Tax')]"))).click().build().perform();
							try
							{
								//Check whether the Tax Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Tax is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Tax is not displayed");
							}

						}
						
						//Disable the required option from enable to disable Discount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Discount Option is Enabled after user click(Disable) the Discount option");

						}
						else
						{

							//Click the Enabled Discount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
							try
							{
								//Check whether the Discount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Discount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Discount is not displayed");
							}
						}
						
						//Disable the required option from enable to disable % Of Sale Option
						if(driver.findElement(By.xpath("//span[contains(.,'% of Sale')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "% Of Sale Option is Enabled after user click(Disable) the % of Sale option");

						}
						else
						{

							//Click the Enabled % Of Sale Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'% of Sale')]"))).click().build().perform();
							try
							{
								//Check whether the % Of Sale Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'% of Sale')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "% Of Sale is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "% Of Sale is not displayed");
							}
						}
		
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for the Required Date Range");
					}
					
				}
				else
				{
					test.log(LogStatus.FAIL, "All dynamic option is not selected");
				}

		}

			@Test(priority=64,enabled = true)
			public void Menu_Item_Sale_method__Report_For_Specific_Date_With_Quantity_Sort_And_Dynamic_Report(WebDriver driver) throws Exception
			{
				Thread.sleep(2000);
				WebElement html = driver.findElement(By.tagName("html"));
				html.sendKeys(Keys.HOME);

				Thread.sleep(3000);
				//Click the Category option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required Category
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				Thread.sleep(3000);
				//Click the Sub Category option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
				//Enter the required Sub Category
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);

				Thread.sleep(3000);
				//Click the Menu Item option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/a")).click();
				//Enter the required Menu Item
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(3000);
				//Click the Serving Level option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/a")).click();
				//Enter the required Serving Level
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				//Check whether the split by serving size is enabled or not
				if(driver.findElement(By.xpath("//input[@ng-model='query.splitBySS']")).isSelected())
				{}
				else
				{
					Thread.sleep(2000);
					//Enable the Split by Serving Level
					Actions act = new Actions(driver);
					act.moveToElement(driver.findElement(By.xpath("//input[@ng-model='query.splitBySS']/../span"))).click().build().perform();
					//driver.findElement(By.xpath("//input[@ng-model='query.splitBySS']/../span")).click();
				}				
				Thread.sleep(3000);
				//Click the Employee option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[6]/div/div/a")).click();
				//Enter the required Employee
				driver.findElement(By.xpath("//form[@name='saleReport']/div[6]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);

				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[7]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[7]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[7]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[8]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[8]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[8]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[8]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				//Check whether the Quantity sort is enabled or not
				if(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']")).isSelected())
				{
					
				}
				else
				{
					//Click the Quantity Sort option
					Actions act = new Actions(driver);
					act.moveToElement(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']/../span"))).click().build().perform();
				}
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				for(int i = 1; i <= 8; i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}Thread.sleep(3000);
				//Check Whether all the field is selected or not
				if(driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'% of Sale')]/../input")).isSelected())
				{
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						//Check whether all the filed is available or not
						if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'% of Sale')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed())
						{
							test.log(LogStatus.PASS, "All the Neccessary fields are displayed");
						}
						else
						{
							test.log(LogStatus.FAIL, "Neccessary fields are not displayed");
						}
						
						//Change the option from enable to Disable the Sale Amount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected())
						{
							//Click the Enabled Sale Amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Sale Amount')]"))).click().build().perform();
							try
							{
								//Check whether the Sale Amount Option is displayed or not
								if(!driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Sale Amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Sale Amount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Sale Amount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Quantity Option
						if(driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected())
						{
							//Click the Enabled Quantity Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Quantity')]"))).click().build().perform();
							try
							{
								//Check whether the Quantity Option is displayed or not
								if(!driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Quantity is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Quantity is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Quantity Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Tax Option
						if(driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected())
						{
							//Click the Enabled Tax Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Tax')]"))).click().build().perform();
							try
							{
								//Check whether the Tax Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Tax is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Tax is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Tax Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Discount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
						{
							//Click the Enabled Discount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
							try
							{
								//Check whether the Discount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Discount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Discount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Discount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the % Of Sale Option
						if(driver.findElement(By.xpath("//span[contains(.,'% of Sale')]/../input")).isSelected())
						{
							//Click the Enabled % Of Sale Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'% of Sale')]"))).click().build().perform();
							try
							{
								//Check whether the % Of Sale Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'% of Sale')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "% Of Sale is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "% Of Sale is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "% Of Sale Option is Disabled When user enter the required date for date range");
						}
						
						//Enable the Sale Amount Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Sale Amount Option is Enabled after user click(Disable) the Sale Amount option");

						}
						else
						{
							//Click the Enabled Sale Amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Sale Amount')]"))).click().build().perform();
							try
							{
								//Check whether the Sale Amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Sale Amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Sale Amount is not displayed");
							}				}
						
						//Disable the required option from enable to disable Quantity Option
						if(driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Quantity Option is Enabled after user click(Disable) the Quantity option");
						}
						else
						{
							//Click the Enabled Quantity Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Quantity')]"))).click().build().perform();
							try
							{
								//Check whether the Quantity Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Quantity is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Quantity is not displayed");
							}

						}
						
						//Disable the required option from enable to disable Tax Option
						if(driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Tax Option is Enabled after user click(Disable) the Tax option");
						}
						else
						{

							//Click the Enabled Tax Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Tax')]"))).click().build().perform();
							try
							{
								//Check whether the Tax Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Tax is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Tax is not displayed");
							}

						}
						
						//Disable the required option from enable to disable Discount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Discount Option is Enabled after user click(Disable) the Discount option");

						}
						else
						{

							//Click the Enabled Discount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
							try
							{
								//Check whether the Discount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Discount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Discount is not displayed");
							}
						}
						
						//Disable the required option from enable to disable % Of Sale Option
						if(driver.findElement(By.xpath("//span[contains(.,'% of Sale')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "% Of Sale Option is Enabled after user click(Disable) the % of Sale option");

						}
						else
						{

							//Click the Enabled % Of Sale Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'% of Sale')]"))).click().build().perform();
							try
							{
								//Check whether the % Of Sale Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'% of Sale')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "% Of Sale is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "% Of Sale is not displayed");
							}
						}
		
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for the Required Date Range");
					}
					
				}
				else
				{
					test.log(LogStatus.FAIL, "All dynamic option is not selected");
				}
			}

			@Test(priority=80)
			public void Modifier_Sale_method_openpage_Report(WebDriver driver) throws Exception
			{
				/*//Click the Reports option
				driver.findElement(By.xpath("//span[.='Reports']")).click();
				// Create instance of Java script executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath("//span[.='Sale']"));
				//Scroll the page till the Sale option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        //Click the Sale Option		
				driver.findElement(By.xpath("//span[.='Sale']")).click(); */
			
				Thread.sleep(3000);
				//Enter the Categories Url
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/modifierSale");
				
				Thread.sleep(3000);
				
				//Check weather the Modifier Sale Report page is loaded or not
				if(driver.findElement(By.xpath("//label[.='Modifier']")).getText().equalsIgnoreCase("Modifier"))
				{
					test.log(LogStatus.PASS, "Modifier Sale Report page loaded successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Modifier Sale Report page loaded fail");
				}

				Thread.sleep(3000);
			}
			
			@Test(priority=81)
			public void Modifier_Sale_method_Report_For_Specific_Date(WebDriver driver) throws Exception
			{
				Thread.sleep(2000);
				WebElement html = driver.findElement(By.tagName("html"));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));

				Thread.sleep(3000);
				//Click the Modifier option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required Modifier
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				//Check whether the Quantity sort is enabled or not
				if(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']")).isSelected())
				{
					//Click the Quantity Sort option
					Actions act = new Actions(driver);
					act.moveToElement(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']/../span"))).click().build().perform();
				}
				else
				{
				}
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Modifier Sale Report is not available for the Required Date Range");
				}
				else
				{
					test.log(LogStatus.PASS, "Modifier Sale Report available for the Required Date Range");
					
				
					Thread.sleep(3000);
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr/th/div/span[.='Modifier Name']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						Thread.sleep(3000);
				        //No.of rows
				        List<WebElement> rows = driver.findElements(By.xpath ("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
				        
		/*		        //Print number of Rows
				        System.out.println("Number of Rows are : "+rows);*/
				        
			        	//Replace all commo's with empty space
			        	String expected1 = Utility.getReportProperty("Modifier_Sale_Report_Sale_Amount").replace(",", "");
			        	
			        	//Convert the String value of the Modifier_Sale_Report_Sale_Amount element into float value
			        	float expect1 = Float.parseFloat(expected1);  
			        	
			        	//Replace all commo's with empty space
			        	String expected2 = Utility.getReportProperty("Modifier_Sale_Report_Quantity").replace(",", "");
			        	
			        	//Convert the String value of the Modifier_Sale_Report_Quantity element into float value
			        	float expect2 = Float.parseFloat(expected2);  
			        	
			        	//Replace all commo's with empty space
			        	String expected3 = Utility.getReportProperty("Modifier_Sale_Report_Tax").replace(",", "");
			        	
			        	//Convert the String value of the Modifier_Sale_Report_Tax element into float value
			        	float expect3 = Float.parseFloat(expected3); 
				        
				        //Check weather the Sale Amount Report is correct or not 
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]")).getText().equals(Utility.getReportProperty("Modifier_Sale_Report_Sale_Amount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Modifier Sale reports are same for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Sale Amount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Sale Amount Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Sale Amount Value is : "+ actual);
				        }
				        
						else if(expect1 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Sale Amount
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]")).getText();

				        	System.out.println("The Actual Sale Amount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Sale Amount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Modifier Sale reports are different for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the sale amount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        			        	
				        	//Get the different
				        	float different = actual - expect1;
				        	
				        	//Print the different value
				        	System.out.println("Sale Amount Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Sale Amount Value different is : "+different);	
				        }
				        
				        //Check weather the Quantity Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]")).getText().equals(Utility.getReportProperty("Modifier_Sale_Report_Quantity")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Modifier Sale reports are same for Quantity");
				        	
				        	//Get the Total value of Quantity
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Quantity Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Quantity Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Quantity Value is : "+ actual);
				        }
				        
						else if(expect2 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Percentage of Sale
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]")).getText();

				        	System.out.println("The Actual Quantity value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Quantity value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Modifier Sale reports are different for Quantity");
				        	
				        	//Get the Total value of Quantity
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Quantity Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect2;
				        	
				        	//Print the different value
				        	System.out.println("Quantity Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Quantity Value different is : "+different);	
				        }
				        
				        //Check weather the Tax Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText().equals(Utility.getReportProperty("Modifier_Sale_Report_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Modifier Sale reports are same for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");   	

				        	//Convert the String value of the Tax Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Tax Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Tax Value is : "+ actual);
				        }
				        
						else if(expect3 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Percentage of Sale
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText();

				        	System.out.println("The Actual Tax value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Modifier Sale reports are different for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Tax Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect3;
				        	
				        	//Print the different value
				        	System.out.println("Tax Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Tax Value different is : "+different);	
				        }
				        
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for the Required Date Range");
					}
				}
			}

			@Test(priority=82)
			public void Modifier_Sale_method_Report_For_Specific_Date_With_Quantity_Sort(WebDriver driver) throws Exception
			{
				Thread.sleep(2000);
				WebElement html = driver.findElement(By.tagName("html"));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));

				Thread.sleep(3000);
				//Click the Modifier option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required Modifier
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				//Check whether the Quantity sort is enabled or not
				if(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']")).isSelected())
				{
					
				}
				else
				{
					//Click the Quantity Sort option
					Actions act = new Actions(driver);
					act.moveToElement(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']/../span"))).click().build().perform();
				}
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Number of rows
				List<WebElement> rowss = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
				int rowa = rowss.size()-1;
				ArrayList<Integer> array = new ArrayList<Integer>();
				for(int i =1; i <= rowa; i++)
				{
					String quan = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+i+"]/td[4]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
					Integer dquan = Integer.parseInt(quan);
					//int quantity = quan.intValue();
					array.add(dquan);
				}
				Collections.sort(array);
				for(int i =0; i < rowa; i++)
				{	int s = i+1;
					String e = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+s+"]/td[4]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
					double actual = Double.parseDouble(e);
					double expect = array.get(i);
					if(actual != expect)
					{
						test.log(LogStatus.PASS, "Sorted by Quantity is Fail");
					}
				}
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Modifier Sale Report is not available for the Required Date Range");
				}
				else
				{
					test.log(LogStatus.PASS, "Modifier Sale Report available for the Required Date Range");
					
				
					Thread.sleep(3000);
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr/th/div/span[.='Modifier Name']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						Thread.sleep(3000);
				        //No.of rows
				        List<WebElement> rows = driver.findElements(By.xpath ("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
				        
		/*		        //Print number of Rows
				        System.out.println("Number of Rows are : "+rows);*/
				        
			        	//Replace all commo's with empty space
			        	String expected1 = Utility.getReportProperty("Modifier_Sale_Report_Sale_Amount").replace(",", "");
			        	
			        	//Convert the String value of the Modifier_Sale_Report_Sale_Amount element into float value
			        	float expect1 = Float.parseFloat(expected1);  
			        	
			        	//Replace all commo's with empty space
			        	String expected2 = Utility.getReportProperty("Modifier_Sale_Report_Quantity").replace(",", "");
			        	
			        	//Convert the String value of the Modifier_Sale_Report_Quantity element into float value
			        	float expect2 = Float.parseFloat(expected2);  
			        	
			        	//Replace all commo's with empty space
			        	String expected3 = Utility.getReportProperty("Modifier_Sale_Report_Tax").replace(",", "");
			        	
			        	//Convert the String value of the Modifier_Sale_Report_Tax element into float value
			        	float expect3 = Float.parseFloat(expected3); 
				        
				        //Check weather the Sale Amount Report is correct or not 
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]")).getText().equals(Utility.getReportProperty("Modifier_Sale_Report_Sale_Amount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Modifier Sale reports are same for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Sale Amount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Sale Amount Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Sale Amount Value is : "+ actual);
				        }
				        
						else if(expect1 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Sale Amount
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]")).getText();

				        	System.out.println("The Actual Sale Amount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Sale Amount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Modifier Sale reports are different for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the sale amount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        			        	
				        	//Get the different
				        	float different = actual - expect1;
				        	
				        	//Print the different value
				        	System.out.println("Sale Amount Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Sale Amount Value different is : "+different);	
				        }
				        
				        //Check weather the Quantity Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]")).getText().equals(Utility.getReportProperty("Modifier_Sale_Report_Quantity")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Modifier Sale reports are same for Quantity");
				        	
				        	//Get the Total value of Quantity
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Quantity Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Quantity Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Quantity Value is : "+ actual);
				        }
				        
						else if(expect2 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Percentage of Sale
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]")).getText();

				        	System.out.println("The Actual Quantity value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Quantity value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Modifier Sale reports are different for Quantity");
				        	
				        	//Get the Total value of Quantity
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Quantity Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect2;
				        	
				        	//Print the different value
				        	System.out.println("Quantity Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Quantity Value different is : "+different);	
				        }
				        
				        //Check weather the Tax Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText().equals(Utility.getReportProperty("Modifier_Sale_Report_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Modifier Sale reports are same for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");   	

				        	//Convert the String value of the Tax Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Tax Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Tax Value is : "+ actual);
				        }
				        
						else if(expect3 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Percentage of Sale
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText();

				        	System.out.println("The Actual Tax value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Modifier Sale reports are different for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Tax Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect3;
				        	
				        	//Print the different value
				        	System.out.println("Tax Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Tax Value different is : "+different);	
				        }
				        
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for the Required Date Range");
					}
				}
			}

			@Test(priority=83)
			public void Modifier_Sale_method_Report_For_Specific_Date_With_Dynamic_Report(WebDriver driver) throws Exception
			{
				Thread.sleep(2000);
				WebElement html = driver.findElement(By.tagName("html"));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));

				Thread.sleep(3000);
				//Click the Modifier option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required Modifier
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				//Check whether the Quantity sort is enabled or not
				if(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']")).isSelected())
				{
					//Click the Quantity Sort option
					Actions act = new Actions(driver);
					act.moveToElement(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']/../span"))).click().build().perform();
				}
				else
				{
				}
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				for(int i = 1; i <= 8; i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}Thread.sleep(3000);
				//Check Whether all the field is selected or not
				if(driver.findElement(By.xpath("//span[contains(.,'Item Name')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected())
				{
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						//Check whether all the filed is available or not
						if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Item Name')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed())
						{
							test.log(LogStatus.PASS, "All the Neccessary fields are displayed");
						}
						else
						{
							test.log(LogStatus.FAIL, "Neccessary fields are not displayed");
						}
						
						//Change the option from enable to Disable the Item Name Option
						if(driver.findElement(By.xpath("//span[contains(.,'Item Name')]/../input")).isSelected())
						{
							//Click the Enabled Item Name Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Item Name')]"))).click().build().perform();
							try
							{
								//Check whether the Item Name Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Item Name')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Item Name is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Item Name is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Item Name Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Sale Amount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected())
						{
							//Click the Enabled Sale Amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Sale Amount')]"))).click().build().perform();
							try
							{
								//Check whether the Sale Amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Sale Amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Sale Amount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Sale Amount Option is Disabled When user enter the required date for date range");
						}
										
						//Change the option from enable to Disable the Quantity Option
						if(driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected())
						{
							//Click the Enabled Quantity Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Quantity')]"))).click().build().perform();
							try
							{
								//Check whether the Quantity Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Quantity is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Quantity is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Quantity Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Tax Option
						if(driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected())
						{
							//Click the Enabled Tax Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Tax')]"))).click().build().perform();
							try
							{
								//Check whether the Tax Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Tax is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Tax is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Tax Option is Disabled When user enter the required date for date range");
						}
						
						//Enable the Item Name Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Item Name')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Item Name Option is Enabled after user click(Disable) the Item Name option");

						}
						else
						{
							//Click the Enabled Item Name Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Item Name')]"))).click().build().perform();
							try
							{
								//Check whether the Item Name Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Item Name')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Item Name is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Item Name is not displayed");
							}				
						}
						
						//Enable the Sale Amount Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Sale Amount Option is Enabled after user click(Disable) the Sale Amount option");

						}
						else
						{
							//Click the Enabled Sale Amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Sale Amount')]"))).click().build().perform();
							try
							{
								//Check whether the Sale Amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Sale Amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Sale Amount is not displayed");
							}				
						}
												
						//Disable the required option from enable to disable Quantity Option
						if(driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Quantity Option is Enabled after user click(Disable) the Quantity option");

						}
						else
						{

							//Click the Enabled Quantity Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Quantity')]"))).click().build().perform();
							try
							{
								//Check whether the Quantity Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Quantity is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Quantity is not displayed");
							}
						}
						
						//Disable the required option from enable to disable Tax Option
						if(driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Tax Option is Enabled after user click(Disable) the Tax option");

						}
						else
						{

							//Click the Enabled Tax Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Tax')]"))).click().build().perform();
							try
							{
								//Check whether the Tax Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Tax is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Tax is not displayed");
							}
						}

					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for the Required Date Range");
					}
					
				}
				else
				{
					test.log(LogStatus.FAIL, "All dynamic option is not selected");
				}
				
			}

			@Test(priority=84)
			public void Modifier_Sale_method_Report_For_Specific_Date_With_Quantity_Sort_And_Dynamic_Report(WebDriver driver) throws Exception
			{
				Thread.sleep(2000);
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

				Thread.sleep(3000);
				//Click the Modifier option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required Modifier
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				//Check whether the Quantity sort is enabled or not
				if(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']")).isSelected())
				{
					
				}
				else
				{
					//Click the Quantity Sort option
					Actions act = new Actions(driver);
					act.moveToElement(driver.findElement(By.xpath("//input[@ng-model='query.qtySort']/../span"))).click().build().perform();
				}
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				for(int i = 1; i <= 8; i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}Thread.sleep(3000);
				//Check Whether all the field is selected or not
				if(driver.findElement(By.xpath("//span[contains(.,'Item Name')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected())
				{
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						//Check whether all the filed is available or not
						if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Item Name')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed())
						{
							test.log(LogStatus.PASS, "All the Neccessary fields are displayed");
						}
						else
						{
							test.log(LogStatus.FAIL, "Neccessary fields are not displayed");
						}
						
						//Change the option from enable to Disable the Item Name Option
						if(driver.findElement(By.xpath("//span[contains(.,'Item Name')]/../input")).isSelected())
						{
							//Click the Enabled Item Name Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Item Name')]"))).click().build().perform();
							try
							{
								//Check whether the Item Name Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Item Name')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Item Name is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Item Name is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Item Name Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Sale Amount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected())
						{
							//Click the Enabled Sale Amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Sale Amount')]"))).click().build().perform();
							try
							{
								//Check whether the Sale Amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Sale Amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Sale Amount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Sale Amount Option is Disabled When user enter the required date for date range");
						}
										
						//Change the option from enable to Disable the Quantity Option
						if(driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected())
						{
							//Click the Enabled Quantity Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Quantity')]"))).click().build().perform();
							try
							{
								//Check whether the Quantity Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Quantity is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Quantity is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Quantity Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Tax Option
						if(driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected())
						{
							//Click the Enabled Tax Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Tax')]"))).click().build().perform();
							try
							{
								//Check whether the Tax Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Tax is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Tax is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Tax Option is Disabled When user enter the required date for date range");
						}
						
						//Enable the Item Name Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Item Name')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Item Name Option is Enabled after user click(Disable) the Item Name option");

						}
						else
						{
							//Click the Enabled Item Name Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Item Name')]"))).click().build().perform();
							try
							{
								//Check whether the Item Name Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Item Name')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Item Name is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Item Name is not displayed");
							}				
						}
						
						//Enable the Sale Amount Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Sale Amount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Sale Amount Option is Enabled after user click(Disable) the Sale Amount option");

						}
						else
						{
							//Click the Enabled Sale Amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Sale Amount')]"))).click().build().perform();
							try
							{
								//Check whether the Sale Amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Sale Amount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Sale Amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Sale Amount is not displayed");
							}				
						}
												
						//Disable the required option from enable to disable Quantity Option
						if(driver.findElement(By.xpath("//span[contains(.,'Quantity')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Quantity Option is Enabled after user click(Disable) the Quantity option");

						}
						else
						{

							//Click the Enabled Quantity Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Quantity')]"))).click().build().perform();
							try
							{
								//Check whether the Quantity Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Quantity')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Quantity is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Quantity is not displayed");
							}
						}
						
						//Disable the required option from enable to disable Tax Option
						if(driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Tax Option is Enabled after user click(Disable) the Tax option");

						}
						else
						{

							//Click the Enabled Tax Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Tax')]"))).click().build().perform();
							try
							{
								//Check whether the Tax Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Tax is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Tax is not displayed");
							}
						}

					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for the Required Date Range");
					}
					
				}
				else
				{
					test.log(LogStatus.FAIL, "All dynamic option is not selected");
				}
			}
			
			@Test(priority=100,enabled = true)
			public void Hourly_Sale_method_openpage_Sale_Report(WebDriver driver) throws Exception
			{
				/*//Click the Reports option
				driver.findElement(By.xpath("//span[.='Reports']")).click();
				// Create instance of Java script executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath("//span[.='Sale']"));
				//Scroll the page till the Sale option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        //Click the Sale Option		
				driver.findElement(By.xpath("//span[.='Sale']")).click(); */
				
				Thread.sleep(3000);
				//Enter the Categories Url
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/hourlySale");
				
				Thread.sleep(3000);
				
				//Check weather the Modifier Sale Report page is loaded or not
				if(driver.findElement(By.xpath("//li[@class='uib-tab nav-item ng-isolate-scope active']/a/uib-tab-heading/span")).getText().equalsIgnoreCase("Hourly Sale"))
				{
					test.log(LogStatus.PASS, "Hourly Sale Report page loaded successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Hourly Sale Report page loaded fail");
				}

				Thread.sleep(3000);

			}
			
			@Test(priority=101,enabled = true)
			public void Hourly_Sale_method_Report_For_Specific_Date(WebDriver driver) throws Exception
			{
				Thread.sleep(2000);
				WebElement html = driver.findElement(By.tagName("html"));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Hourly Sale Report is not available for Specific Date");
				}
				else
				{
					test.log(LogStatus.PASS, "Hourly Sale Report available for Specific Date");
					
					Thread.sleep(3000);
					//Check Weather the Top 5 hourly sale available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Here Top 5 Hourly Sale Report available for Specific Date");
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);
						
						//Click the Pie chart option
						driver.findElement(By.xpath("//a[.='Pie']")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Pie Chart available");
						Thread.sleep(3000);
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);
		
						//Click the Polar Area chart option
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/ul/li[2]/a")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Polar Area Chart available");
						Thread.sleep(3000);
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);
		
						//Click the Bar chart option
						driver.findElement(By.xpath("//a[.='Bar']")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Bar Chart available");
						Thread.sleep(3000);
					}
					else
					{
						test.log(LogStatus.FAIL, "Here Top 5 Hourly Sale Report not available for Specific Date");
					}
					
					Thread.sleep(5000);
					//Check weather the report graph is available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
					{
						test.log(LogStatus.PASS, "There is Graphical type of Hourly sale report is available for Specific Date");
					}
					else
					{
						test.log(LogStatus.FAIL, "Graphical report is not available for Specific Date");
					}
					
					Thread.sleep(5000);
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for Specific Date");
						
						Thread.sleep(3000);
				        //No.of rows
				        List<WebElement> rows = driver.findElements(By.xpath ("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
				        
		/*		        //Print number of Rows
				        System.out.println("Number of Rows are : "+rows);*/
				        
						//Replace all commo's with empty space
						String expected1 = Utility.getReportProperty("Sale_Report_Net_Sale").replace(",", "");
						
						//Convert the String value of the Sale_Report_Net_Sale element into float value
						float expect1 = Float.parseFloat(expected1); 
		
						//Replace all commo's with empty space
						String expected2 = Utility.getReportProperty("Sale_Report_Tax").replace(",", "");
						
						//Convert the String value of the Sale_Report_Tax element into float value
						float expect2 = Float.parseFloat(expected2);  
		
						//Replace all commo's with empty space
						String expected3 = Utility.getReportProperty("Sale_Report_Discount").replace(",", "");
						
						//Convert the String value of the Sale_Report_Discount element into float value
						float expect3 = Float.parseFloat(expected3);     	
		
						//Replace all commo's with empty space
						String expected4 = Utility.getReportProperty("Sale_Report_Grand_Sale").replace(",", "");
								
						//Convert the String value of the Sale_Report_Grand_Sale element into float value
						float expect4= Float.parseFloat(expected4);  
				        
			        	//Replace all commo's with empty space
			        	String expected5 = Utility.getReportProperty("Hourly_Sale_Report_Number_Of_Customer").replace(",", "");
			        	
			        	//Convert the String value of the Hourly_Sale_Report_Number_Of_Customer element into float value
			        	float expect5 = Float.parseFloat(expected5);  
				        
				        //Check weather the Net Sale is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Net_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Net Sale Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Net Sale Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Net Sale Value is : "+ actual);
				        }
				        
						else if(expect1 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Net Sale
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		
				        	System.out.println("The Actual Net Sale value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Net Sale value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the net sale amount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        			        	
				        	//Get the different
				        	float different = actual - expect1;
				        	
				        	//Print the different value
				        	System.out.println("Net Sale Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Net Sale Value different is : "+different);	
				        }
				        
				        //Check weather the Tax Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Tax Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Tax Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Tax Value is : "+ actual);
				        }
				        
						else if(expect2 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Tax
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		
				        	System.out.println("The Actual Tax value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Tax Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect2;
				        	
				        	//Print the different value
				        	System.out.println("Tax Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Tax Value different is : "+different);	
				        }
				        
				        
				        //Check weather the Discount Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Discount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Discount Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Discount Value is : "+ actual);
				        }
				        
						else if(expect3 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Discount
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		
				        	System.out.println("The Actual Discount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Discount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect3;
				        	
				        	//Print the different value
				        	System.out.println("Discount Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Discount Value different is : "+different);	
				        }
				        
				        
				        //Check weather the Grand Sale Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Grand_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Grand Sale");
				        	
				        	//Get the Total value of Grand Sale
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");   	
		
				        	//Convert the String value of the Grand Sale Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Grand Sale Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Grand Sale Value is : "+ actual);
				        }
				        
						else if(expect4 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Sale Report
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
		
				        	System.out.println("The Actual Grand Sale value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Grand Sale value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Grand Sale");
				        	
				        	//Get the Total value of Grand Sale
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Grand Sale Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect4;
				        	
				        	//Print the different value
				        	System.out.println("Grand Sale Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Grand Sale Value different is : "+different);	
				        }
				        
				        
				        //Check weather the Number of Customer Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[7]/span")).getText().equals(Utility.getReportProperty("Hourly_Sale_Report_Number_Of_Customer")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Hourly Sale reports are same for Number of Customer");
				        	
				        	//Get the Total value of Number of Customer
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Number of Customer Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Number of Customer Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Number of Customer Value is : "+ actual);
				        }
				        
						else if(expect5 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Number of Customer
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
		
				        	System.out.println("The Actual Number of Customer value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Number of Customer value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Hourly Sale reports are different for Number of Customer");
				        	
				        	//Get the Total value of Number of Customer
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Number of Customer Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect5;
				        	
				        	//Print the different value
				        	System.out.println("Number of Customer Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Number of Customer Value different is : "+different);	
				        }
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for Specific Date");
					}
				}
			}
		
			@Test(priority=102,enabled = true)
			public void Hourly_Sale_method_Report_For_Specific_Date_With_Dynamic_Report(WebDriver driver) throws Exception
		{
			Thread.sleep(2000);
			WebElement html = driver.findElement(By.tagName("html"));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	
			Thread.sleep(3000);
			//Click the Time Period option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
			//Enter the required Time Period
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("Date Range");
			//Press the Enter Key
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/input[1]")).clear();
			//Enter the date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
			Thread.sleep(2000);
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/input[2]")).clear();
			//Enter the date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			
			Thread.sleep(2000);
			//Click the Run Button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			Thread.sleep(3000);
			for(int i = 1; i <= 8; i++)
			{
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			}Thread.sleep(3000);
			//Check Whether all the field is selected or not
			if(driver.findElement(By.xpath("//span[contains(.,'Net Sale')]/../input")).isSelected()
					&&driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected()
					&&driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected()
					&&driver.findElement(By.xpath("//span[contains(.,'Grand Sale')]/../input")).isSelected()
					&&driver.findElement(By.xpath("//span[contains(.,'Number Of Customer')]/../input")).isSelected())
			{
				//Check weather the table format report is available or not
				if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
					
					//Check whether all the filed is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net Sale')]")).isDisplayed()
							&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed()
							&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed()
							&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Grand Sale')]")).isDisplayed()
							&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Number Of Customer')]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "All the Neccessary fields are displayed");
					}
					else
					{
						test.log(LogStatus.FAIL, "Neccessary fields are not displayed");
					}
					
					//Change the option from enable to Disable the Net Sale Option
					if(driver.findElement(By.xpath("//span[contains(.,'Net Sale')]/../input")).isSelected())
					{
						//Click the Enabled Net Sale Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Net Sale')]"))).click().build().perform();
						try
						{
							//Check whether the Net Sale Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net Sale')]")).isDisplayed())
							{
								test.log(LogStatus.FAIL, "Net Sale is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.PASS, "Net Sale is not displayed");
						}
					}
					else
					{
						test.log(LogStatus.FAIL, "Net Sale Option is Disabled When user enter the required date for date range");
					}
					
					//Change the option from enable to Disable the Tax Option
					if(driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected())
					{
						//Click the Enabled Tax Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Tax')]"))).click().build().perform();
						try
						{
							//Check whether the Tax Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed())
							{
								test.log(LogStatus.FAIL, "Tax is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.PASS, "Tax is not displayed");
						}
					}
					else
					{
						test.log(LogStatus.FAIL, "Tax Option is Disabled When user enter the required date for date range");
					}
									
					//Change the option from enable to Disable the Discount Option
					if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
					{
						//Click the Enabled Discount Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
						try
						{
							//Check whether the Discount Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
							{
								test.log(LogStatus.FAIL, "Discount is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.PASS, "Discount is not displayed");
						}
					}
					else
					{
						test.log(LogStatus.FAIL, "Discount Option is Disabled When user enter the required date for date range");
					}
					
					//Change the option from enable to Disable the Grand Sale Option
					if(driver.findElement(By.xpath("//span[contains(.,'Grand Sale')]/../input")).isSelected())
					{
						//Click the Enabled Grand Sale Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Grand Sale')]"))).click().build().perform();
						try
						{
							//Check whether the Grand Sale Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Grand Sale')]")).isDisplayed())
							{
								test.log(LogStatus.FAIL, "Grand Sale is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.PASS, "Grand Sale is not displayed");
						}
					}
					else
					{
						test.log(LogStatus.FAIL, "Grand Sale Option is Disabled When user enter the required date for date range");
					}
					
					//Change the option from enable to Disable the Number Of Customer Option
					if(driver.findElement(By.xpath("//span[contains(.,'Number Of Customer')]/../input")).isSelected())
					{
						//Click the Enabled Number Of Customer Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Number Of Customer')]"))).click().build().perform();
						try
						{
							//Check whether the Number Of Customer Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Number Of Customer')]")).isDisplayed())
							{
								test.log(LogStatus.FAIL, "Number Of Customer is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.PASS, "Number Of Customer is not displayed");
						}
					}
					else
					{
						test.log(LogStatus.FAIL, "Number Of Customer Option is Disabled When user enter the required date for date range");
					}
					
					//Enable the Net Sale Option if it is in disabled status
					if(driver.findElement(By.xpath("//span[contains(.,'Net Sale')]/../input")).isSelected())
					{
						test.log(LogStatus.FAIL, "Net Sale Option is Enabled after user click(Disable) the Net Sale option");
	
					}
					else
					{
						//Click the Enabled Net Sale Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Net Sale')]"))).click().build().perform();
						try
						{
							//Check whether the Net Sale Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net Sale')]")).isDisplayed())
							{
								test.log(LogStatus.PASS, "Net Sale is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Net Sale is not displayed");
						}				
					}
					
					//Enable the Tax Option if it is in disabled status
					if(driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected())
					{
						test.log(LogStatus.FAIL, "Tax Option is Enabled after user click(Disable) the Tax option");
	
					}
					else
					{
						//Click the Enabled Tax Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Tax')]"))).click().build().perform();
						try
						{
							//Check whether the Tax Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed())
							{
								test.log(LogStatus.PASS, "Tax is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Tax is not displayed");
						}				
					}
					
											
					//Disable the required option from enable to disable Discount Option
					if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
					{
						test.log(LogStatus.FAIL, "Discount Option is Enabled after user click(Disable) the Discount option");
	
					}
					else
					{
	
						//Click the Enabled Discount Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
						try
						{
							//Check whether the Discount Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
							{
								test.log(LogStatus.PASS, "Discount is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Discount is not displayed");
						}
					}
					
					//Disable the required option from enable to disable Grand Sale Option
					if(driver.findElement(By.xpath("//span[contains(.,'Grand Sale')]/../input")).isSelected())
					{
						test.log(LogStatus.FAIL, "Grand Sale Option is Enabled after user click(Disable) the Grand Sale option");
	
					}
					else
					{
	
						//Click the Enabled Grand Sale Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Grand Sale')]"))).click().build().perform();
						try
						{
							//Check whether the Grand Sale Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Grand Sale')]")).isDisplayed())
							{
								test.log(LogStatus.PASS, "Grand Sale is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Grand Sale is not displayed");
						}
					}
	
					//Disable the required option from enable to disable Number Of Customer Option
					if(driver.findElement(By.xpath("//span[contains(.,'Number Of Customer')]/../input")).isSelected())
					{
						test.log(LogStatus.FAIL, "Number Of Customer Option is Enabled after user click(Disable) the Number Of Customer option");
	
					}
					else
					{
	
						//Click the Enabled Number Of Customer Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Number Of Customer')]"))).click().build().perform();
						try
						{
							//Check whether the Number Of Customer Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Number Of Customer')]")).isDisplayed())
							{
								test.log(LogStatus.PASS, "Number Of Customer is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Number Of Customer is not displayed");
						}
					}
				}
				else
				{
					test.log(LogStatus.FAIL, "Table Format Report is not available for the Required Date Range");
				}
				
			}
			else
			{
				test.log(LogStatus.FAIL, "All dynamic option is not selected");
			}
		}

			@Test(priority=120,enabled = true)
			public void Daily_Sale_method_openpage_Report(WebDriver driver) throws Exception
			{
				/*//Click the Reports option
				driver.findElement(By.xpath("//span[.='Reports']")).click();
				// Create instance of Java script executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath("//span[.='Sale']"));
				//Scroll the page till the Sale option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        //Click the Sale Option		
				driver.findElement(By.xpath("//span[.='Sale']")).click();	*/
				
				Thread.sleep(3000);
				//Enter the Categories Url
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+("report/dailySale"));
				
				Thread.sleep(3000);
				
				//Check weather the Modifier Sale Report page is loaded or not
				if(driver.findElement(By.xpath("//li[@class='uib-tab nav-item ng-isolate-scope active']/a/uib-tab-heading/span")).getText().equalsIgnoreCase("Daily Sale"))
				{
					test.log(LogStatus.PASS, "Daily Sale Sale Report page loaded successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Daily Sale Sale Report page loaded fail");
				}

				Thread.sleep(3000);

			}
			
			@Test(priority=121,enabled = true)
			public void Daily_Sale_method_Report_For_Specific_Date(WebDriver driver) throws Exception
			{
				Thread.sleep(2000);
				WebElement html = driver.findElement(By.tagName("html"));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Daily Sale Report is not available for Specific Date");
				}
				else
				{
					test.log(LogStatus.PASS, "Daily Sale Report available for Specific Date");
					
					Thread.sleep(3000);
					//Check Weather the Top 5 daily sale available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Here Top 5 Daily Sale Report available for Specific Date");
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);
						
						//Click the Pie chart option
						driver.findElement(By.xpath("//a[.='Pie']")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Pie Chart available");
						Thread.sleep(3000);
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);
		
						//Click the Polar Area chart option
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/ul/li[2]/a")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Polar Area Chart available");
						Thread.sleep(3000);
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[1]/div/div[1]/div[2]/div/button[2]")).click();
						Thread.sleep(1000);
		
						//Click the Bar chart option
						driver.findElement(By.xpath("//a[.='Bar']")).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Bar Chart available");
						Thread.sleep(3000);
					}
					else
					{
						test.log(LogStatus.FAIL, "Here Top 5 Daily Sale Report not available for Specific Date");
					}
					
					Thread.sleep(5000);
					//Check weather the report graph is available or not
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[5]/div/div[2]/div/canvas")).isDisplayed())
					{
						test.log(LogStatus.PASS, "There is Graphical type of Daily sale report is available for Specific Date");
					}
					else
					{
						test.log(LogStatus.FAIL, "Graphical report is not available for Specific Date");
					}
					
					Thread.sleep(5000);
					
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for Specific Date");
						
						Thread.sleep(3000);
				        //No.of rows
				        List<WebElement> rows = driver.findElements(By.xpath ("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
				        
		/*		        //Print number of Rows
				        System.out.println("Number of Rows are : "+rows);*/
				        
			        	//Replace all commo's with empty space
			        	String expected1 = Utility.getReportProperty("Sale_Report_Net_Sale").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Net_Sale element into float value
			        	float expect1 = Float.parseFloat(expected1); 
						
			        	//Replace all commo's with empty space
			        	String expected2 = Utility.getReportProperty("Sale_Report_Tax").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Tax element into float value
			        	float expect2 = Float.parseFloat(expected2); 
						
			        	//Replace all commo's with empty space
			        	String expected3 = Utility.getReportProperty("Sale_Report_Discount").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Discount element into float value
			        	float expect3 = Float.parseFloat(expected3);  
						
			        	//Replace all commo's with empty space
			        	String expected4 = Utility.getReportProperty("Sale_Report_Grand_Sale").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Grand_Sale element into float value
			        	float expect4 = Float.parseFloat(expected4); 
				        
				        //Check weather the Net Sale is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Net_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Daily Sale reports are same for Net Sale");
				        	
				        	//Get the Total value of net Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Net Sale Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Net Sale Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Net Sale Value is : "+ actual);
				        }
				        
						else if(expect1 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Net Sale
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
		
				        	System.out.println("The Actual Net Sale value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Net Sale value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Daily Sale reports are different for Sale Amount");
				        	
				        	//Get the Total value of Sale Amount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the net sale amount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        			        	
				        	//Get the different
				        	float different = actual - expect1;
				        	
				        	//Print the different value
				        	System.out.println("Net Sale Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Net Sale Value different is : "+different);	
				        }
				        
				        //Check weather the Tax Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Daily Sale reports are same for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Tax Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Tax Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Tax Value is : "+ actual);
				        }
				        
						else if(expect2 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Tax
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
		
				        	System.out.println("The Actual Tax value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Daily Sale reports are different for Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Tax Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect2;
				        	
				        	//Print the different value
				        	System.out.println("Tax Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Tax Value different is : "+different);	
				        }
				        
				        
				        //Check weather the Discount Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Daily Sale reports are same for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Discount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Discount Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Discount Value is : "+ actual);
				        }
				        
						else if(expect3 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Discount
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
		
				        	System.out.println("The Actual Discount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Daily Sale reports are different for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Discount Total element into float value
				        	float actual = Float.parseFloat(actualText);       		
				        	
				        	//Get the different
				        	float different = actual - expect3;
				        	
				        	//Print the different value
				        	System.out.println("Discount Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Discount Value different is : "+different);	
				        }
				        
				        
				        //Check weather the Grand Sale Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Grand_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Daily Sale reports are same for Grand Sale");
				        	
				        	//Get the Total value of Grand Sale
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");   	
		
				        	//Convert the String value of the Grand Sale Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Grand Sale Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Grand Sale Value is : "+ actual);
				        }
				        
						else if(expect4 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Grand Sale
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
		
				        	System.out.println("The Actual Grand Sale value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Grand Sale value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Daily Sale reports are different for Grand Sale");
				        	
				        	//Get the Total value of Grand Sale
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Grand Sale Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect4;
				        	
				        	//Print the different value
				        	System.out.println("Grand Sale Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Grand Sale Value different is : "+different);	
				        }
				        
				        
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for Specific Date");
					}
				}
			}
		
			@Test(priority=122,enabled = true)
			public void Daily_Sale_method_Report_For_Specific_Date_With_Dynamic_Report(WebDriver driver) throws Exception
		{
			Thread.sleep(2000);
			WebElement html = driver.findElement(By.tagName("html"));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	
			Thread.sleep(3000);
			//Click the Time Period option
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
			//Enter the required Time Period
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("Date Range");
			//Press the Enter Key
			driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/input[1]")).clear();
			//Enter the date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
			Thread.sleep(2000);
			//Clear the date field
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/input[2]")).clear();
			//Enter the date
			driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			
			Thread.sleep(2000);
			//Click the Run Button
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			Thread.sleep(3000);
			for(int i = 1; i <= 8; i++)
			{
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			}Thread.sleep(3000);
			//Check Whether all the field is selected or not
			if(driver.findElement(By.xpath("//span[contains(.,'Net Sale')]/../input")).isSelected()
					&&driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected()
					&&driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected()
					&&driver.findElement(By.xpath("//span[contains(.,'Grand Sale')]/../input")).isSelected())
			{
				//Check weather the table format report is available or not
				if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
					
					//Check whether all the filed is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net Sale')]")).isDisplayed()
							&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed()
							&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed()
							&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Grand Sale')]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "All the Neccessary fields are displayed");
					}
					else
					{
						test.log(LogStatus.FAIL, "Neccessary fields are not displayed");
					}
					
					//Change the option from enable to Disable the Net Sale Option
					if(driver.findElement(By.xpath("//span[contains(.,'Net Sale')]/../input")).isSelected())
					{
						//Click the Enabled Net Sale Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Net Sale')]"))).click().build().perform();
						try
						{
							//Check whether the Net Sale Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net Sale')]")).isDisplayed())
							{
								test.log(LogStatus.FAIL, "Net Sale is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.PASS, "Net Sale is not displayed");
						}
					}
					else
					{
						test.log(LogStatus.FAIL, "Net Sale Option is Disabled When user enter the required date for date range");
					}
					
					//Change the option from enable to Disable the Tax Option
					if(driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected())
					{
						//Click the Enabled Tax Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Tax')]"))).click().build().perform();
						try
						{
							//Check whether the Tax Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed())
							{
								test.log(LogStatus.FAIL, "Tax is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.PASS, "Tax is not displayed");
						}
					}
					else
					{
						test.log(LogStatus.FAIL, "Tax Option is Disabled When user enter the required date for date range");
					}
									
					//Change the option from enable to Disable the Discount Option
					if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
					{
						//Click the Enabled Discount Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
						try
						{
							//Check whether the Discount Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
							{
								test.log(LogStatus.FAIL, "Discount is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.PASS, "Discount is not displayed");
						}
					}
					else
					{
						test.log(LogStatus.FAIL, "Discount Option is Disabled When user enter the required date for date range");
					}
					
					//Change the option from enable to Disable the Grand Sale Option
					if(driver.findElement(By.xpath("//span[contains(.,'Grand Sale')]/../input")).isSelected())
					{
						//Click the Enabled Grand Sale Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Grand Sale')]"))).click().build().perform();
						try
						{
							//Check whether the Grand Sale Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Grand Sale')]")).isDisplayed())
							{
								test.log(LogStatus.FAIL, "Grand Sale is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.PASS, "Grand Sale is not displayed");
						}
					}
					else
					{
						test.log(LogStatus.FAIL, "Grand Sale Option is Disabled When user enter the required date for date range");
					}
					
					//Enable the Net Sale Option if it is in disabled status
					if(driver.findElement(By.xpath("//span[contains(.,'Net Sale')]/../input")).isSelected())
					{
						test.log(LogStatus.FAIL, "Net Sale Option is Enabled after user click(Disable) the Net Sale option");
	
					}
					else
					{
						//Click the Enabled Net Sale Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Net Sale')]"))).click().build().perform();
						try
						{
							//Check whether the Net Sale Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net Sale')]")).isDisplayed())
							{
								test.log(LogStatus.PASS, "Net Sale is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Net Sale is not displayed");
						}				
					}
					
					//Enable the Tax Option if it is in disabled status
					if(driver.findElement(By.xpath("//span[contains(.,'Tax')]/../input")).isSelected())
					{
						test.log(LogStatus.FAIL, "Tax Option is Enabled after user click(Disable) the Tax option");
	
					}
					else
					{
						//Click the Enabled Tax Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Tax')]"))).click().build().perform();
						try
						{
							//Check whether the Tax Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Tax')]")).isDisplayed())
							{
								test.log(LogStatus.PASS, "Tax is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Tax is not displayed");
						}				
					}
					
											
					//Disable the required option from enable to disable Discount Option
					if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
					{
						test.log(LogStatus.FAIL, "Discount Option is Enabled after user click(Disable) the Discount option");
	
					}
					else
					{
	
						//Click the Enabled Discount Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
						try
						{
							//Check whether the Discount Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
							{
								test.log(LogStatus.PASS, "Discount is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Discount is not displayed");
						}
					}
					
					//Disable the required option from enable to disable Grand Sale Option
					if(driver.findElement(By.xpath("//span[contains(.,'Grand Sale')]/../input")).isSelected())
					{
						test.log(LogStatus.FAIL, "Grand Sale Option is Enabled after user click(Disable) the Grand Sale option");
	
					}
					else
					{
	
						//Click the Enabled Grand Sale Option
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Grand Sale')]"))).click().build().perform();
						try
						{
							//Check whether the Grand Sale Option is displayed or not
							if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Grand Sale')]")).isDisplayed())
							{
								test.log(LogStatus.PASS, "Grand Sale is displayed");
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Grand Sale is not displayed");
						}
					}
	
				}
				else
				{
					test.log(LogStatus.FAIL, "Table Format Report is not available for the Required Date Range");
				}
				
			}
			else
			{
				test.log(LogStatus.FAIL, "All dynamic option is not selected");
			}
			
		}

			@Test(priority=140,enabled = true)
			public void Sale_Recap_Sale_method_openpage_Report(WebDriver driver) throws Exception
			{
				/*//Click the Reports option
				driver.findElement(By.xpath("//span[.='Reports']")).click();
				// Create instance of Java script executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath("//span[.='Sale']"));
				//Scroll the page till the Sale option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        //Click the Sale Option		
				driver.findElement(By.xpath("//span[.='Sale']")).click(); */
				

				Thread.sleep(3000);
				//Enter the SaleRecap Url
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/saleRecap");
				
				Thread.sleep(3000);
				
				//Check weather the Sale Recap Report page is loaded or not
				if(driver.findElement(By.xpath("//label[.='Sale recap Type']")).getText().equalsIgnoreCase("Sale recap Type"))
				{
					test.log(LogStatus.PASS, "Sale Recap Report page loaded successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Sale Recap Report page loaded fail");
				}

				Thread.sleep(3000);

			}	
			
			@Test(priority=141,enabled = true)
			public void Sale_Recap_Sale_method_Verify_Report(WebDriver driver) throws Exception
			{

				Thread.sleep(3000);
				//Click the Select Recap Type option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/a")).click();
				//Enter the required department
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/input")).sendKeys("Time period");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
			
				Thread.sleep(3000);
				//Click the Employee option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/a")).click();
				//Enter the required employee
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Check weather the Check Status 
				if(driver.getPageSource().contains("CHECK STATS"))
				{
					test.log(LogStatus.PASS, "Check Stats field is available");
					
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Check_Count").replace(",", "");
		        	
		        	//Convert the String value of the Check_Count element into float value
		        	float expect1 = Float.parseFloat(expected1);  

					
					Thread.sleep(2000);
					//Check the Check Count
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[2]/span")).getText().equals(Utility.getReportProperty("Check_Count")))
					{
						test.log(LogStatus.PASS, "Actual and Expected check counts are same");
						
			        	//Get the Total value of Check Count
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[2]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Check Count Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Check Count Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Check Count Value is : "+ actual);

					}
					
					else if(expect1 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Check Count
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[2]/span")).getText();

			        	System.out.println("The Actual Check Count value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Check Count value is : "+actualText);
					}
					
					else
					{
						test.log(LogStatus.FAIL, "Actual and Expected Check counts are different");
						
			        	//Get the Total value of Check Count
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[2]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Check Count Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect1;
			        	
			        	//Print the different value
			        	System.out.println("Check Count Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Check Count Value different is : "+different);	

					}
					
					Thread.sleep(3000);
					//Check the SALES
					if(driver.getPageSource().contains("SALES"))
					{
						test.log(LogStatus.INFO, "SALES is available");
						
						System.out.println("SALES is available");
						
			        	//Replace all commo's with empty space
			        	String expecte1 = Utility.getReportProperty("Gross_Sales").replace(",", "");
			        	
			        	//Convert the String value of the Gross_Sales element into float value
			        	float expects1 = Float.parseFloat(expecte1);  
			        	
			        	//Replace all commo's with empty space
			        	String expected2 = Utility.getReportProperty("Sale_Report_Net_Sale").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Net_Sale element into float value
			        	float expect2 = Float.parseFloat(expected2);
			        	
			        	//Replace all commo's with empty space
			        	String expected3 = Utility.getReportProperty("Sale_Report_Grand_Sale").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Grand_Sale element into float value
			        	float expect3 = Float.parseFloat(expected3);
			        	
			        	//Check weather the Gross Sales total is same or not
			        	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[2]/span")).getText().equals(Utility.getReportProperty("Gross_Sales")))
			        	{
				        	test.log(LogStatus.PASS, "Actual and Expected Gross Sales Values are same");
				        	
				        	//Get the Total value of Gross Sales
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[2]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Gross Sales element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Gross Sales Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Gross Sales Value is : "+ actual);
				        }
				        
						else if(expects1 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Gross Sales
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[2]/span")).getText();

				        	System.out.println("The Actual Gross Sales value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Gross Sales value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Gross Sales values are different");
				        	
				        	//Get the Total value of Gross Sales
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[2]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Gross Sales Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expects1;
				        	
				        	//Print the different value
				        	System.out.println("Gross Sales Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Gross Sales Value different is : "+different);	
				        }
			        	
			        	//Check weather the Net Sales total is same or not
			        	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Net_Sale")))
			        	{
				        	test.log(LogStatus.PASS, "Actual and Expected Net Sales Values are same");
				        	
				        	//Get the Total value of Net Sales
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[3]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Net Sales element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Net Sales Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Net Sales Value is : "+ actual);
				        }
				        
						else if(expect2 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Net Sales
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[3]/span")).getText();

				        	System.out.println("The Actual Net Sales value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Net Sales value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Net Sales values are different");
				        	
				        	//Get the Total value of Gross Sales
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[3]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Net Sales Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect2;
				        	
				        	//Print the different value
				        	System.out.println("Net Sales Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Net Sales Value different is : "+different);	
				        }
			        	
			        	//Check weather the Grand Sales total is same or not
			        	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Grand_Sale")))
			        	{
				        	test.log(LogStatus.PASS, "Actual and Expected Grand Sales Values are same");
				        	
				        	//Get the Total value of Grand Sales
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[4]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Grand Sales element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Grand Sales Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Grand Sales Value is : "+ actual);
				        }
				        
						else if(expect3 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Grand Sales
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[4]/span")).getText();

				        	System.out.println("The Actual Grand Sales value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Grand Sales value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Grand Sales values are different");
				        	
				        	//Get the Total value of Grand Sales
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[4]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Net Sales Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect3;
				        	
				        	//Print the different value
				        	System.out.println("Grand Sales Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Grand Sales Value different is : "+different);	
				        }
			        	
					}
					else
					{
						test.log(LogStatus.INFO, "Sales is not available");
						
						System.out.println("Sales is not available");
					}
				}
				else
				{
					test.log(LogStatus.FAIL, "Check Stats field is not available");
					
					
					
					Thread.sleep(3000);
					//Check the SALES
					if(driver.getPageSource().contains("SALES"))
					{
						test.log(LogStatus.INFO, "SALES is available");
						
						System.out.println("SALES is available");
						
			        	//Replace all commo's with empty space
			        	String expected1 = Utility.getReportProperty("Gross_Sales").replace(",", "");
			        	
			        	//Convert the String value of the Gross_Sales element into float value
			        	float expect1 = Float.parseFloat(expected1);  
			        	
			        	//Replace all commo's with empty space
			        	String expected2 = Utility.getReportProperty("Sale_Report_Net_Sale").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Net_Sale element into float value
			        	float expect2 = Float.parseFloat(expected2);
			        	
			        	//Replace all commo's with empty space
			        	String expected3 = Utility.getReportProperty("Sale_Report_Grand_Sale").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Grand_Sale element into float value
			        	float expect3 = Float.parseFloat(expected3);
			        	
			        	//Check weather the Gross Sales total is same or not
			        	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[2]/span")).getText().equals(Utility.getReportProperty("Gross_Sales")))
			        	{
				        	test.log(LogStatus.PASS, "Actual and Expected Gross Sales Values are same");
				        	
				        	//Get the Total value of Gross Sales
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[2]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Gross Sales element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Gross Sales Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Gross Sales Value is : "+ actual);
				        }
				        
						else if(expect1 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Gross Sales
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[2]/span")).getText();

				        	System.out.println("The Actual Gross Sales value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Gross Sales value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Gross Sales values are different");
				        	
				        	//Get the Total value of Gross Sales
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[2]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Gross Sales Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect1;
				        	
				        	//Print the different value
				        	System.out.println("Gross Sales Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Gross Sales Value different is : "+different);	
				        }
			        	
			        	//Check weather the Net Sales total is same or not
			        	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Net_Sale")))
			        	{
				        	test.log(LogStatus.PASS, "Actual and Expected Net Sales Values are same");
				        	
				        	//Get the Total value of Net Sales
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[3]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Net Sales element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Net Sales Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Net Sales Value is : "+ actual);
				        }
				        
						else if(expect2 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Net Sales
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[3]/span")).getText();

				        	System.out.println("The Actual Net Sales value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Net Sales value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Net Sales values are different");
				        	
				        	//Get the Total value of Gross Sales
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[3]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Net Sales Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect2;
				        	
				        	//Print the different value
				        	System.out.println("Net Sales Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Net Sales Value different is : "+different);	
				        }
			        	
			        	//Check weather the Grand Sales total is same or not
			        	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Grand_Sale")))
			        	{
				        	test.log(LogStatus.PASS, "Actual and Expected Grand Sales Values are same");
				        	
				        	//Get the Total value of Grand Sales
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[4]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Grand Sales element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Grand Sales Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Grand Sales Value is : "+ actual);
				        }
				        
						else if(expect3 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Grand Sales
				        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[4]/span")).getText();

				        	System.out.println("The Actual Grand Sales value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Grand Sales value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Grand Sales values are different");
				        	
				        	//Get the Total value of Grand Sales
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[4]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Net Sales Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect3;
				        	
				        	//Print the different value
				        	System.out.println("Grand Sales Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Grand Sales Value different is : "+different);	
				        }
			        	
					}
					else
					{
						test.log(LogStatus.INFO, "Sales is not available");
						
						System.out.println("Sales is not available");
					}
				}

			}
			
			@Test(priority=160,enabled = true)
			public void Cashier_Out_Sale_method_open__Report(WebDriver driver) throws Exception
			{
				/*//Click the Reports option
				driver.findElement(By.xpath("//span[.='Reports']")).click();
				// Create instance of Java script executor*/
				JavascriptExecutor je = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath("//span[.='Sale']"));
				//Scroll the page till the Sale option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        /*//Click the Sale Option		
				driver.findElement(By.xpath("//span[.='Sale']")).click(); */
				

				Thread.sleep(3000);
				//Enter the Cashierout Url
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/cashierOut");
				
				Thread.sleep(3000);
				
				//Check weather the Cashier Out Report page is loaded or not
				if(driver.findElement(By.xpath("//li[@class='uib-tab nav-item ng-isolate-scope active']/a/uib-tab-heading/span")).getText().equalsIgnoreCase("Cashier out"))
				{
					test.log(LogStatus.PASS, "Cashier Out Report page loaded successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Cashier Out Report page loaded fail");
				}

				Thread.sleep(3000);

			}	
			
			@Test(priority=161,enabled = true)
			public void Cashier_Out_Sale_method_verify_Report(WebDriver driver) throws Exception
			{

				Thread.sleep(3000);
				//Click the Employee option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
				//Enter the required employee
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
				

				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[3]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Check weather the Check Status 
				if(driver.getPageSource().contains("CHECK STATS"))
				{
					test.log(LogStatus.PASS, "Check Stats field is available");
					
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Check_Count").replace(",", "");
		        	
		        	//Convert the String value of the Check_Count element into float value
		        	float expect1 = Float.parseFloat(expected1);  

					
					Thread.sleep(2000);
					//Check the Check Count
					if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[2]/span")).getText().equals(Utility.getReportProperty("Check_Count")))
					{
						test.log(LogStatus.PASS, "Actual and Expected check counts are same");
						
			        	//Get the Total value of Check Count
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[2]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Check Count Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Check Count Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Check Count Value is : "+ actual);

					}
					
					else if(expect1 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Check Count
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[2]/span")).getText();

			        	System.out.println("The Actual Check Count value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Check Count value is : "+actualText);
					}
					
					else
					{
						test.log(LogStatus.FAIL, "Actual and Expected Check counts are different");
						
			        	//Get the Total value of Check Count
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[1]/div[2]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Check Count Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect1;
			        	
			        	//Print the different value
			        	System.out.println("Check Count Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Check Count Value different is : "+different);	

					}
				}
				else
				{
					test.log(LogStatus.FAIL, "Check Stats field is not available");
				}

				Thread.sleep(3000);
				//Check the SALES
				if(driver.getPageSource().contains("SALES"))
				{
					test.log(LogStatus.INFO, "SALES is available");
					
					System.out.println("SALES is available");
					
		        	//Replace all commo's with empty space
		        	String expected1 = Utility.getReportProperty("Gross_Sales").replace(",", "");
		        	
		        	//Convert the String value of the Gross_Sales element into float value
		        	float expect1 = Float.parseFloat(expected1);  
		        	
		        	//Replace all commo's with empty space
		        	String expected2 = Utility.getReportProperty("Sale_Report_Net_Sale").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Net_Sale element into float value
		        	float expect2 = Float.parseFloat(expected2);
		        	
		        	//Replace all commo's with empty space
		        	String expected3 = Utility.getReportProperty("Sale_Report_Grand_Sale").replace(",", "");
		        	
		        	//Convert the String value of the Sale_Report_Grand_Sale element into float value
		        	float expect3 = Float.parseFloat(expected3);
		        	
		        	//Check weather the Gross Sales total is same or not
		        	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[2]/span")).getText().equals(Utility.getReportProperty("Gross_Sales")))
		        	{
			        	test.log(LogStatus.PASS, "Actual and Expected Gross Sales Values are same");
			        	
			        	//Get the Total value of Gross Sales
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[2]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Gross Sales element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Gross Sales Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Gross Sales Value is : "+ actual);
			        }
			        
					else if(expect1 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Gross Sales
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[2]/span")).getText();

			        	System.out.println("The Actual Gross Sales value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Gross Sales value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Gross Sales values are different");
			        	
			        	//Get the Total value of Gross Sales
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[2]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Gross Sales Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect1;
			        	
			        	//Print the different value
			        	System.out.println("Gross Sales Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Gross Sales Value different is : "+different);	
			        }
		        	
		        	//Check weather the Net Sales total is same or not
		        	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Net_Sale")))
		        	{
			        	test.log(LogStatus.PASS, "Actual and Expected Net Sales Values are same");
			        	
			        	//Get the Total value of Net Sales
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[3]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Net Sales element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Net Sales Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Net Sales Value is : "+ actual);
			        }
			        
					else if(expect2 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Net Sales
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[3]/span")).getText();

			        	System.out.println("The Actual Net Sales value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Net Sales value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Net Sales values are different");
			        	
			        	//Get the Total value of Gross Sales
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[3]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Net Sales Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect2;
			        	
			        	//Print the different value
			        	System.out.println("Net Sales Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Net Sales Value different is : "+different);	
			        }
		        	
		        	//Check weather the Grand Sales total is same or not
		        	if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Grand_Sale")))
		        	{
			        	test.log(LogStatus.PASS, "Actual and Expected Grand Sales Values are same");
			        	
			        	//Get the Total value of Grand Sales
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[4]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Grand Sales element into float value
			        	float actual = Float.parseFloat(actualText);
			        	
			        	//Print the actual value
			        	System.out.println("The Actual Grand Sales Value is : "+actual);
			        	
			        	test.log(LogStatus.PASS, "The Actual Grand Sales Value is : "+ actual);
			        }
			        
					else if(expect3 == unknownValue)
					{
						test.log(LogStatus.PASS, "Here we don't have the exact expected value");
						
			        	//Get the Total value of Grand Sales
			        	String actualText = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[4]/span")).getText();

			        	System.out.println("The Actual Grand Sales value is : "+actualText);
			        	
			        	test.log(LogStatus.INFO, "The Actual Grand Sales value is : "+actualText);
					}
			        
			        else
			        {
			        	test.log(LogStatus.FAIL, "Actual and Expected Grand Sales values are different");
			        	
			        	//Get the Total value of Grand Sales
			        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[4]/div/div[2]/div[4]/span")).getText();
			        	
			        	//Replace all commo's with empty space
			        	String actualText= actualText1.replace(",", "");
			        	
			        	//Convert the String value of the Net Sales Total element into float value
			        	float actual = Float.parseFloat(actualText);
			        			        	
			        	//Get the different
			        	float different = actual - expect3;
			        	
			        	//Print the different value
			        	System.out.println("Grand Sales Value different is : "+different);
			        	
			        	test.log(LogStatus.FAIL, "Grand Sales Value different is : "+different);	
			        }
		        	
				}
				else
				{
					test.log(LogStatus.INFO, "Sales is not available");
					
					System.out.println("Sales is not available");
				}
			}

			@Test(priority=180,enabled = true)
			public void Weekly_SaleSummary_method_Report_Openpage(WebDriver driver) throws Exception
			{
				/*WebElement html = driver.findElement(By.tagName("html"));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				
				//Click the Reports option
				driver.findElement(By.xpath("//span[.='Reports']")).click();
				// Create instance of Java script executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath("//span[.='Sale']"));
				//Scroll the page till the Sale option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        //Click the Sale Option		
				driver.findElement(By.xpath("//span[.='Sale']")).click();*/
				
				Thread.sleep(3000);
				//Enter the Categories Url
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/weeklySale");
				
				// Create instance of Java script executor
				JavascriptExecutor je1 = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element1 = driver.findElement(By.xpath("//span[.=' Weekly Summary ']"));
				//Scroll the page till the Weekly Summary option present
				je1.executeScript("arguments[0].scrollIntoView(true);",element1); 
				
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
				//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
				//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
				//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
				//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
				
				//Check weather the Weekly Summary Report page is loaded or not
				if(driver.findElement(By.xpath("//li[@class='uib-tab nav-item ng-isolate-scope active']/a/uib-tab-heading/span")).getText().equalsIgnoreCase("Weekly Summary"))
				{
					test.log(LogStatus.PASS, "Weekly Summary Report page loaded successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Weekly Summary Report page loaded fail");
				}

				Thread.sleep(3000);
				
			}
			
			@Test(priority=181,enabled = true)
			public void Weekly_Summary_Sale_method_Report_This_Week(WebDriver driver) throws Exception
			{

				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("This week");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(10000);
				//Check weather the Table Type report available or not for This Week
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Table format reprot is available for This Week");
								
					
					List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr/td[1]"));
					for(int i = 2; i <= rows.size(); i++)
					{
						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]")).getText().equalsIgnoreCase("Gross Sales"))
						{
							
							List<WebElement> Column = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td"));
							
				        	//Replace all commo's with empty space
				        	String expected1 = Utility.getReportProperty("This_Weekly_Gross_Sale").replace("/[^A-Za-z ,â‚¹$]/", "");
				        	
				        	//Convert the String value of the This_Weekly_Gross_Sale element into float value
				        	float expect1 = Float.parseFloat(expected1);  
				        	
				        	//Get the Total value of Check Count
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column.size()+"]")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replaceAll("/[^A-Za-z ,â‚¹$]/", "");
				        	
							Thread.sleep(2000);
							//Check the Gross Sale
							if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column.size()+"]")).getText().equals(Utility.getReportProperty("This_Weekly_Gross_Sale")))
							{
								test.log(LogStatus.PASS, "Actual and Expected Gross Sale is same");
									        	
					        	//Convert the String value of the Gross Sale Total element into float value
					        	float actual = Float.parseFloat(actualText);
					        	
					        	//Print the actual value
					        	System.out.println("The Actual Gross Sale(This Week) Value is : "+actual);
					        	
					        	test.log(LogStatus.PASS, "The Actual Gross Sale(This Week) Value is : "+ actual);

							}
							
							else if(expect1 == unknownValue)
							{
								test.log(LogStatus.PASS, "Here we don't have the exact expected value");
								
					        	System.out.println("The Actual Gross Sale(This Week) value is : "+actualText);
					        	
					        	test.log(LogStatus.INFO, "The Actual Gross Sale(This Week) value is : "+actualText);
							}
							
							else
							{
								test.log(LogStatus.FAIL, "Actual and Expected Gross Sale is different");
					        	
					        	//Convert the String value of the Gross Sale Total element into float value
					        	float actual = Float.parseFloat(actualText);
					        			        	
					        	//Get the different
					        	float different = actual - expect1;
					        	
					        	//Print the different value
					        	System.out.println("Gross Sale(This Week) Actual value is : "+actualText1);
					        	
					        	test.log(LogStatus.FAIL, "Gross Sale(This Week) Actual value is : "+actualText1);	
					        	
					        	//Print the different value
					        	System.out.println("Gross Sale(This Week) different is : "+different);
					        	
					        	test.log(LogStatus.FAIL, "Gross Sale(This Week) different is : "+different);	

							}
							
						}
					}
					
					for(int i = 2; i <= rows.size(); i++)
					{
						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]")).getText().equalsIgnoreCase("Net Sales"))
						{
							
							List<WebElement> Column1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td"));
							
				        	//Replace all commo's with empty space
				        	String expected2 = Utility.getReportProperty("This_Weekly_Net_Sale").replace("/[^A-Za-z ,â‚¹$]/", "");
				        	
				        	//Convert the String value of the This_Weekly_Net_Sale element into float value
				        	float expect2 = Float.parseFloat(expected2);  
				        	
				        	//Get the Total value of Net Sale
				        	String actualText3 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column1.size()+"]")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText2 = actualText3.replaceAll("/[^A-Za-z ,â‚¹$]/", "");
								
							Thread.sleep(2000);
							//Check the Net Sale
							if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column1.size()+"]")).getText().equals(Utility.getReportProperty("This_Weekly_Net_Sale")))
							{
								test.log(LogStatus.PASS, "Actual and Expected Net Sale is same");
									        	
					        	//Convert the String value of the Net Sale Total element into float value
					        	float actual = Float.parseFloat(actualText2);
					        	
					        	//Print the actual value
					        	System.out.println("The Actual Net Sale(This Week) Value is : "+actual);
					        	
					        	test.log(LogStatus.PASS, "The Actual Net Sale(This Week) Value is : "+ actual);

							}
							
							else if(expect2 == unknownValue)
							{
								test.log(LogStatus.PASS, "Here we don't have the exact expected value");
								
					        	System.out.println("The Actual Net Sale(This Week) value is : "+actualText2);
					        	
					        	test.log(LogStatus.INFO, "The Actual Net Sale(This Week) value is : "+actualText2);
							}
							
							else
							{
								test.log(LogStatus.FAIL, "Actual and Expected Net Sale is different");
					        	
					        	//Convert the String value of the Gross Sale Total element into float value
					        	float actual = Float.parseFloat(actualText2);
					        			        	
					        	//Get the different
					        	float different = actual - expect2;
					        	
					        	//Print the different value
					        	System.out.println("Net Sale(This Week) Actual value is : "+actualText3);
					        	
					        	test.log(LogStatus.FAIL, "Net Sale(This Week) Actual value is : "+actualText3);
					        	
					        	//Print the different value
					        	System.out.println("Net Sale(This Week) different is : "+different);
					        	
					        	test.log(LogStatus.FAIL, "Net Sale(This Week) different is : "+different);	

							}

							}

					}

				}
				else
				{
					test.log(LogStatus.FAIL, "Table format report is not available for This Week");
				}
			}
			
			@Test(priority=182,enabled = true)
			public void Weekly_Summary_Sale_method_Report_Last_Week(WebDriver driver) throws Exception
			{

				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("Last week");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(10000);
				//Check weather the Table Type report available or not for Last Week
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Table format reprot is available for Last Week");
								
					List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr/td[1]"));
					for(int i = 2; i <= rows.size(); i++)
					{
						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]")).getText().equalsIgnoreCase("Gross Sales"))
						{
							
							List<WebElement> Column = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td"));
							
				        	//Replace all commo's with empty space
				        	String expected1 = Utility.getReportProperty("This_Weekly_Gross_Sale").replace("/[^A-Za-z ,â‚¹$]/", "");
				        	
				        	//Convert the String value of the This_Weekly_Gross_Sale element into float value
				        	float expect1 = Float.parseFloat(expected1);  
				        	
				        	//Get the Total value of Check Count
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column.size()+"]")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replaceAll("/[^A-Za-z ,â‚¹$]/", "");
				        	
							Thread.sleep(2000);
							//Check the Gross Sale
							if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column.size()+"]")).getText().equals(Utility.getReportProperty("This_Weekly_Gross_Sale")))
							{
								test.log(LogStatus.PASS, "Actual and Expected Gross Sale is same");
									        	
					        	//Convert the String value of the Gross Sale Total element into float value
					        	float actual = Float.parseFloat(actualText);
					        	
					        	//Print the actual value
					        	System.out.println("The Actual Gross Sale(Last Week) Value is : "+actual);
					        	
					        	test.log(LogStatus.PASS, "The Actual Gross Sale(Last Week) Value is : "+ actual);

							}
							
							else if(expect1 == unknownValue)
							{
								test.log(LogStatus.PASS, "Here we don't have the exact expected value");
								
					        	System.out.println("The Actual Gross Sale(Last Week) value is : "+actualText);
					        	
					        	test.log(LogStatus.INFO, "The Actual Gross Sale(Last Week) value is : "+actualText);
							}
							
							else
							{
								test.log(LogStatus.FAIL, "Actual and Expected Gross Sale is different");
					        	
					        	//Convert the String value of the Gross Sale Total element into float value
					        	float actual = Float.parseFloat(actualText);
					        			        	
					        	//Get the different
					        	float different = actual - expect1;
					        	
					        	//Print the different value
					        	System.out.println("Gross Sale(Last Week) Actual value is : "+actualText1);
					        	
					        	test.log(LogStatus.FAIL, "Gross Sale(Last Week) Actual value is : "+actualText1);
					        	
					        	//Print the different value
					        	System.out.println("Gross Sale(Last Week) different is : "+different);
					        	
					        	test.log(LogStatus.FAIL, "Gross Sale(Last Week) different is : "+different);	

							}
							
						}
					}
					
					for(int i = 2; i <= rows.size(); i++)
					{
						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]")).getText().equalsIgnoreCase("Net Sales"))
						{
							
							List<WebElement> Column1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td"));
							
				        	//Replace all commo's with empty space
				        	String expected2 = Utility.getReportProperty("This_Weekly_Net_Sale").replace("/[^A-Za-z ,â‚¹$]/", "");
				        	
				        	//Convert the String value of the This_Weekly_Net_Sale element into float value
				        	float expect2 = Float.parseFloat(expected2);  
				        	
				        	//Get the Total value of Check Count
				        	String actualText3 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column1.size()+"]")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText2 = actualText3.replaceAll("/[^A-Za-z ,â‚¹$]/", "");
								
							Thread.sleep(2000);
							//Check the Net Sale
							if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column1.size()+"]")).getText().equals(Utility.getReportProperty("This_Weekly_Net_Sale")))
							{
								test.log(LogStatus.PASS, "Actual and Expected Net Sale is same");
									        	
					        	//Convert the String value of the Net Sale Total element into float value
					        	float actual = Float.parseFloat(actualText2);
					        	
					        	//Print the actual value
					        	System.out.println("The Actual Net Sale(Last Week) Value is : "+actual);
					        	
					        	test.log(LogStatus.PASS, "The Actual Net Sale(Last Week) Value is : "+ actual);

							}
							
							else if(expect2 == unknownValue)
							{
								test.log(LogStatus.PASS, "Here we don't have the exact expected value");
								
					        	System.out.println("The Actual Net Sale(Last Week) value is : "+actualText2);
					        	
					        	test.log(LogStatus.INFO, "The Actual Net Sale(Last Week) value is : "+actualText2);
							}
							
							else
							{
								test.log(LogStatus.FAIL, "Actual and Expected Net Sale is different");
					        	
					        	//Convert the String value of the Gross Sale Total element into float value
					        	float actual = Float.parseFloat(actualText2);
					        			        	
					        	//Get the different
					        	float different = actual - expect2;
					        	
					        	//Print the different value
					        	System.out.println("Net Sale(Last Week) Actual value is : "+actualText3);
					        	
					        	test.log(LogStatus.FAIL, "Net Sale(Last Week) Actual value is : "+actualText3);
					        	
					        	//Print the different value
					        	System.out.println("Net Sale(Last Week) different is : "+different);
					        	
					        	test.log(LogStatus.FAIL, "Net Sale(Last Week) different is : "+different);	

							}

							}

					}
				}
				else
				{
					test.log(LogStatus.FAIL, "Table format report is not available for Last Week");
				}
			}
			
			@Test(priority=183,enabled = true)
			public void Weekly_Summary_Sale_method_Report_Last7days(WebDriver driver) throws Exception
			{

				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys("Last 7 days");
				//Press the Enter Key
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/form/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(10000);
				//Check weather the Table Type report available or not for Last 7 days
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[7]/table")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Table format reprot is available for Last 7 Days");
								
					List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr/td[1]"));
					for(int i = 2; i <= rows.size(); i++)
					{
						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]")).getText().equalsIgnoreCase("Gross Sales"))
						{
							
							List<WebElement> Column = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td"));
							
				        	//Replace all commo's with empty space
				        	String expected1 = Utility.getReportProperty("This_Weekly_Gross_Sale").replace("/[^A-Za-z ,â‚¹$]/", "");
				        	
				        	//Convert the String value of the This_Weekly_Gross_Sale element into float value
				        	float expect1 = Float.parseFloat(expected1);  
				        	
				        	//Get the Total value of Check Count
				        	String actualText1 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column.size()+"]")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replaceAll("/[^A-Za-z ,â‚¹$]/", "");
				        	
							Thread.sleep(2000);
							//Check the Gross Sale
							if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column.size()+"]")).getText().equals(Utility.getReportProperty("This_Weekly_Gross_Sale")))
							{
								test.log(LogStatus.PASS, "Actual and Expected Gross Sale is same");
									        	
					        	//Convert the String value of the Gross Sale Total element into float value
					        	float actual = Float.parseFloat(actualText);
					        	
					        	//Print the actual value
					        	System.out.println("The Actual Gross Sale(Last 7 Days) Value is : "+actual);
					        	
					        	test.log(LogStatus.PASS, "The Actual Gross Sale(Last 7 Days) Value is : "+ actual);

							}
							
							else if(expect1 == unknownValue)
							{
								test.log(LogStatus.PASS, "Here we don't have the exact expected value");
								
					        	System.out.println("The Actual Gross Sale(Last 7 Days) value is : "+actualText);
					        	
					        	test.log(LogStatus.INFO, "The Actual Gross Sale(Last 7 Days) value is : "+actualText);
							}
							
							else
							{
								test.log(LogStatus.FAIL, "Actual and Expected Gross Sale is different");
					        	
					        	//Convert the String value of the Gross Sale Total element into float value
					        	float actual = Float.parseFloat(actualText);
					        			        	
					        	//Get the different
					        	float different = actual - expect1;
					        	
					        	//Print the different value
					        	System.out.println("Gross Sale(Last 7 Days) Actual value is : "+actualText1);
					        	
					        	test.log(LogStatus.FAIL, "Gross Sale(Last 7 Days) Actual value is : "+actualText1);
					        	
					        	//Print the different value
					        	System.out.println("Gross Sale(Last 7 Days) different is : "+different);
					        	
					        	test.log(LogStatus.FAIL, "Gross Sale(Last 7 Days) different is : "+different);	

							}
							
						}
					}
					
					for(int i = 2; i <= rows.size(); i++)
					{
						if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td[1]")).getText().equalsIgnoreCase("Net Sales"))
						{
							
							List<WebElement> Column1 = driver.findElements(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td"));
							
				        	//Replace all commo's with empty space
				        	String expected2 = Utility.getReportProperty("This_Weekly_Net_Sale").replace("/[^A-Za-z ,â‚¹$]/", "");
				        	
				        	//Convert the String value of the This_Weekly_Net_Sale element into float value
				        	float expect2 = Float.parseFloat(expected2);  
				        	
				        	//Get the Total value of Check Count
				        	String actualText3 = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column1.size()+"]")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText2 = actualText3.replaceAll("/[^A-Za-z ,â‚¹$]/", "");
								
							Thread.sleep(2000);
							//Check the Net Sale
							if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[6]/table/tbody/tr["+i+"]/td["+Column1.size()+"]")).getText().equals(Utility.getReportProperty("This_Weekly_Net_Sale")))
							{
								test.log(LogStatus.PASS, "Actual and Expected Net Sale is same");
									        	
					        	//Convert the String value of the Net Sale Total element into float value
					        	float actual = Float.parseFloat(actualText2);
					        	
					        	//Print the actual value
					        	System.out.println("The Actual Net Sale(Last 7 Days) Value is : "+actual);
					        	
					        	test.log(LogStatus.PASS, "The Actual Net Sale(Last 7 Days) Value is : "+ actual);

							}
							
							else if(expect2 == unknownValue)
							{
								test.log(LogStatus.PASS, "Here we don't have the exact expected value");
								
					        	System.out.println("The Actual Net Sale(Last 7 Days) value is : "+actualText2);
					        	
					        	test.log(LogStatus.INFO, "The Actual Net(Last 7 Days) Sale value is : "+actualText2);
							}
							
							else
							{
								test.log(LogStatus.FAIL, "Actual and Expected Net Sale is different");
					        	
					        	//Convert the String value of the Gross Sale Total element into float value
					        	float actual = Float.parseFloat(actualText2);
					        			        	
					        	//Get the different
					        	float different = actual - expect2;
					        	
					        	//Print the different value
					        	System.out.println("Net Sale(Last 7 Days) Actual value is : "+actualText3);
					        	
					        	test.log(LogStatus.FAIL, "Net Sale(Last 7 Days) Actual value is : "+actualText3);
					        	
					        	//Print the different value
					        	System.out.println("Net Sale(Last 7 Days) different is : "+different);
					        	
					        	test.log(LogStatus.FAIL, "Net Sale(Last 7 Days) different is : "+different);	

							}

							}

					}
				}
				else
				{
					test.log(LogStatus.FAIL, "Table format report is not available for Last 7 Days");
				}
			}
	
			@Test(priority=200)
			public void Sale_Summary_Sale_method_Report_open_Page(WebDriver driver) throws Exception
			{
			
				/*Thread.sleep(2000);
				WebElement html = driver.findElement(By.tagName("html"));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				*/
				
			/*	//Click the Reports option
				driver.findElement(By.xpath("//span[.='Reports']")).click();
				// Create instance of Java script executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath("//span[.='Sale']"));
				//Scroll the page till the Sale option present
				je.executeScript("arguments[0].scrollIntoView(true);",element); 
		        //Click the Sale Option		
				driver.findElement(By.xpath("//span[.='Sale']")).click(); */
				

				Thread.sleep(3000);
				//Enter the Categories Url
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/saleSummary");
				
				Thread.sleep(4000);
				//Click the right arrow button
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
				driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();

				//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
				//driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/button[2]")).click();
				
				Thread.sleep(3000);
				//Check weather the Sale Summary page is opened or not
				if(driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div[1]/div/div/div/div/scrollable-tabset/div/div/div/ul/li[11]/a/uib-tab-heading/span")).getText().equalsIgnoreCase("Sale Summary"))
				{
					test.log(LogStatus.PASS, "Sale Summary Report Page Loaded Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Sale Summary Report Page Loaded Fail");
				}
				Thread.sleep(3000);
			}
			
			@Test(priority=201)
			public void Sale_Saummary_Sale_method_Report_For_Specific_Date(WebDriver driver) throws Exception
			{

				Thread.sleep(3000);
				//Click the Employee option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required employee
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
				/*Thread.sleep(3000);
				//Click the Check Number Search option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).clear();
				//Enter the Check Number
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).sendKeys("0-007");
				*/
				
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
			
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			
				Thread.sleep(3000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Sale Summary Report is not available for the Required Date Range");
				}
				else
				{
					test.log(LogStatus.PASS, "Sale Summary Report available for the Required Date Range");
							
					Thread.sleep(3000);
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						Thread.sleep(3000);
				        //No.of rows
				        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
				        
		/*	        //Print number of Rows
				        System.out.println("Number of Rows are : "+rows);*/
				        
			        	
			        	//Replace all commo's with empty space
			        	String expected1 = Utility.getReportProperty("Sale_Report_Net_Sale").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Net_Sale element into float value
			        	float expect1 = Float.parseFloat(expected1);  
			        		        	
			        	//Replace all commo's with empty space
			        	String expected2 = Utility.getReportProperty("Sale_Report_Tax").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Tax element into float value
			        	float expect2 = Float.parseFloat(expected2);  
			        	
			        	//Replace all commo's with empty space
			        	String expected3 = Utility.getReportProperty("Sale_Report_Inclusive_Tax").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Inclusive_Tax element into float value
			        	float expect3 = Float.parseFloat(expected3);  

			        	//Replace all commo's with empty space
			        	String expected4 = Utility.getReportProperty("CC_Service_Charge").replace(",", "");
			        	
			        	//Convert the String value of the CC_Service_Charge element into float value
			        	float expect4 = Float.parseFloat(expected4);  
			        	
			        	//Replace all commo's with empty space
			        	String expected5 = Utility.getReportProperty("Sale_Report_Discount").replace(",", "");
			        	
			        	//Convert the String value of the Sale_Report_Discount element into float value
			        	float expect5 = Float.parseFloat(expected5);  
			        	
			        	//Replace all commo's with empty space
			        	String expected6 = Utility.getReportProperty("Gross_Receipt").replace(",", "");
			        	
			        	//Convert the String value of the Gross_Receipt element into float value
			        	float expect6 = Float.parseFloat(expected6); 
				        
				        //Check weather the Transaction Date Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Net_Sale")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Net Transaction Date");
				        	
				        	//Get the Total value of Net Transaction Date
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Net Transaction Date Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Net Transaction Date Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Net Transaction Date Value is : "+ actual);
				        }
				        
						else if(expect1 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Check Count
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();

				        	System.out.println("The Actual Net Transaction Date value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Net Transaction Date value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Net Transaction Date");
				        	
				        	//Get the Total value of Transaction Date
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the net Transaction Date Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect1;
				        	
				        	//Print the different value
				        	System.out.println("Net Transaction Date Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Net Transaction Date Value different is : "+different);	
				        }
				        
				        //Check weather the Tax Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Tax reports are same for Quantity");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Tax Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Tax Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Tax Value is : "+ actual);
				        }
				        
						else if(expect2 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Quantity
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();

				        	System.out.println("The Actual Tax value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Tax");
				        	
				        	//Get the Total value of Quantity
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Tax Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Get the different
				        	float different = actual - expect2;
				        	
				        	//Print the different value
				        	System.out.println("Tax Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Tax Value different is : "+different);	
				        }
				        
				        //Check weather the Inclusive Tax Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Inclusive_Tax")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Inclusive Tax");
				        	
				        	//Get the Total value of Inclusive Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");   	

				        	//Convert the String value of the Inclusive Tax Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Inclusive Tax Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Inclusive Tax Value is : "+ actual);
				        }
				        
						else if(expect3 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Tax
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();

				        	System.out.println("The Actual Inclusive Tax value is : "+actualText);		 
				        	
				        	test.log(LogStatus.INFO, "The Actual Inclusive Tax value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Inclusive Tax");
				        	
				        	//Get the Total value of Tax
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Tax Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect3;
				        	
				        	//Print the different value
				        	System.out.println("Tax Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Tax Value different is : "+different);	
				        }
				        
				        //Check weather the CC Service Charge Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText().equals(Utility.getReportProperty("CC_Service_Charge")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Department Sale reports are same for Discount");
				        	
				        	//Get the Total value of CC Service Charge
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the CC Service Charge Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual CC Service Charge Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual CC Service Charge Value is : "+ actual);
				        }
				        
						else if(expect4 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of CC Service Charge
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();

				        	System.out.println("The Actual CC Service Charge value is : "+actualText);	
				        	
				        	test.log(LogStatus.INFO, "The Actual CC Service Charge value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for CC Service Charge");
				        	
				        	//Get the Total value of CC Service Charge
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the CC Service Charge Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect4;
				        	
				        	//Print the different value
				        	System.out.println("CC Service Charge Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "CC Service Charge Value different is : "+different);	
				        }
				        
				        //Check weather the Discount Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[7]/span")).getText().equals(Utility.getReportProperty("Sale_Report_Discount")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Discount");
				        	
				        	//Get the Total value of Discount
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Discount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Discount Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Discount Value is : "+ actual);
				        }
				        
						else if(expect5 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Discount
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[7]/span")).getText();

				        	System.out.println("The Actual Discount value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Discount value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Discount");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Discount Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect5;
				        	
				        	//Print the different value
				        	System.out.println("Discount Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Discount Value different is : "+different);	
				        }
				        
				        //Check weather the Gross Receipt Report is correct or not
				        if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]/span")).getText().equals(Utility.getReportProperty("Gross_Receipt")))
				        {
				        	test.log(LogStatus.PASS, "Actual and Expected Sale Summary reports are same for Gross Receipt");
				        	
				        	//Get the Total value of Gross Receipt
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Gross Receipt Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        	
				        	//Print the actual value
				        	System.out.println("The Actual Gross Receipt Value is : "+actual);
				        	
				        	test.log(LogStatus.PASS, "The Actual Gross Receipt Value is : "+ actual);
				        }
				        
						else if(expect6 == unknownValue)
						{
							test.log(LogStatus.PASS, "Here we don't have the exact expected value");
							
				        	//Get the Total value of Percentage Of Sale
				        	String actualText = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]/span")).getText();

				        	System.out.println("The Actual Gross Receipt value is : "+actualText);
				        	
				        	test.log(LogStatus.INFO, "The Actual Gross Receipt value is : "+actualText);
						}
				        
				        else
				        {
				        	test.log(LogStatus.FAIL, "Actual and Expected Sale Summary reports are different for Gross Receipt");
				        	
				        	//Get the Total value of Percentage Of Sale
				        	String actualText1 = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]/span")).getText();
				        	
				        	//Replace all commo's with empty space
				        	String actualText= actualText1.replace(",", "");
				        	
				        	//Convert the String value of the Percentage Of Sale Total element into float value
				        	float actual = Float.parseFloat(actualText);
				        			        	
				        	//Get the different
				        	float different = actual - expect6;
				        	
				        	//Print the different value
				        	System.out.println("Gross Receipt Value different is : "+different);
				        	
				        	test.log(LogStatus.FAIL, "Gross Receipt Value different is : "+different);	
				        }
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for the Required Date Range");
					}
				}
			}

			@Test(priority=202)
			public void Sale_Saummary_Sale_method_Report_For_Specific_Date_WithService_Type(WebDriver driver) throws Exception
			{

				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				Thread.sleep(3000);
				//Click the Employee option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required employee
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
				/*Thread.sleep(3000);
				//Click the Check Number Search option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).clear();
				//Enter the Check Number
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).sendKeys("0-007");
				*/
				
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
			
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				Thread.sleep(3000);
				//Click the OrderType 		
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul")).click();
				Thread.sleep(3000);
				//Enter the Service_Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Utility.getReportProperty("Service_Type"));
				
				Thread.sleep(1000);
				//Press the Service Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(3000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Sale Summary Report is not available for the Required Date Range and Required Service Type");
				}
				else
				{
					test.log(LogStatus.PASS, "Sale Summary Report available for the Required Date Range and Required Service Type");
				}
				
				Thread.sleep(5000);
				//Close the Service Type
				driver.findElement(By.xpath("//li[@class='search-choice']/a")).click();
			}

			@Test(priority=203)
			public void Sale_Saummary_Sale_method_Report_For_Specific_Date_WithSearch(WebDriver driver) throws Exception
			{
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				Thread.sleep(3000);
				//Click the Employee option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required employee
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);	
				
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
			
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
						
				Thread.sleep(3000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				Thread.sleep(3000);
				//Get the value of first cell of table
				String check = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr[10]/td[1]/a")).getText();
				
				Thread.sleep(3000);
				//Click the Check Number Search option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).clear();
				//Enter the Check Number
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).sendKeys(check);

				Thread.sleep(3000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Sale Summary Report is not available for the Required Date Range");
				}
				else
				{
					test.log(LogStatus.PASS, "Sale Summary Report available for the Required Date Range");
				}
				
				Thread.sleep(3000);
				//Click the Check Number Search option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).clear();
			}

			@Test(priority=204)
			public void Sale_Saummary_Sale_method_Report_For_Specific_Date_WithSearchAndServiceType(WebDriver driver) throws Exception
			{
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				Thread.sleep(3000);
				//Click the Employee option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required employee
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);	
				
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
			
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
						
				Thread.sleep(3000);
				//Click the OrderType 		
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul")).click();
				Thread.sleep(3000);
				//Enter the Service_Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys("QSR");
				
				Thread.sleep(3000);
				//Press the Service Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

				Thread.sleep(3000);
				//Enter the Service_Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys("Phone - DELIVERY");
				
				Thread.sleep(3000);
				//Press the Service Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

				Thread.sleep(3000);
				//Enter the Service_Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys("Web - DELIVERY");
				
				Thread.sleep(3000);
				//Press the Service Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

				
				Thread.sleep(3000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath("//h3[.='No sale for selected time period']")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Sale Summary Report is not available for the Required Date Range");
				}
				else
				{
					Thread.sleep(3000);
					//Get the value of first cell of table
					String check = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr[1]/td[1]/a")).getText();
					
					Thread.sleep(3000);
					//Click the Check Number Search option
					driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).clear();
					//Enter the Check Number
					driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).sendKeys(check);

					Thread.sleep(3000);
					//Click the Run Button
					driver.findElement(By.xpath("//button[@type='submit']")).click();
					
					test.log(LogStatus.PASS, "Sale Summary Report available for the Required Date Range");
					
/*					String netSales = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr[1]/td[3]/span")).getText();
					double netSalesAmt = Double.parseDouble(netSales);*/
					
					String totTax = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr[1]/td[4]/span")).getText();
					double totTaxAmt = Double.parseDouble(totTax);
					
/*					String incTax = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr[1]/td[5]/span")).getText();
					double inclusiveTaxAmt = Double.parseDouble(incTax);*/
					
					String ccServiceCharge = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr[1]/td[6]/span")).getText();
					double ccServiceChargeAmt = Double.parseDouble(ccServiceCharge);
					
					String disc = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr[1]/td[7]/span")).getText();
					double discAmt = Double.parseDouble(disc);
					
					String grossReceipt = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr[1]/td[8]/span")).getText();
					double grossReceiptAmt = Double.parseDouble(grossReceipt);
					
					//Click the Required Check
					driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr[1]/td[1]/a")).click();
					
					Thread.sleep(3000);
					//Get the Total Value
					String gross = driver.findElement(By.xpath("//th[.='Total']/../td")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
					double grossAmt = Double.parseDouble(gross);
				
					//Get the Tax Value
					String tx =  driver.findElement(By.xpath("//td[text()[normalize-space()='Tax Total']]/../td[2]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
					double txAmt = Double.parseDouble(tx);
				
					//Get the CC Service Charge Value
					String ccs =  driver.findElement(By.xpath("//th[contains(.,'CC Service')]/../..//tr[3]/td[4]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
					double ccsAmt = Double.parseDouble(ccs);
					
					//Get the Discount Value
					String dis =  driver.findElement(By.xpath("//th[.='Discount']/../td")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
					double disAmt = Double.parseDouble(dis);

					//Check whether the Gross Receipt value is correct or not 
					if(grossReceiptAmt == grossAmt)
					{
						test.log(LogStatus.PASS, "Gross Recipt value is correct");
					}
					else
					{
						double diff = grossReceiptAmt - grossAmt;
						test.log(LogStatus.FAIL, "Gross Recipt value is different : "+diff);
					}
					
					//Check whether the Total Tax is correct or not
					if(totTaxAmt == txAmt)
					{
						test.log(LogStatus.PASS, "Total Tax value is correct");
					}
					else
					{
						double diff = totTaxAmt - txAmt;
						test.log(LogStatus.FAIL, "Total Tax value is different : "+diff);
					}
					
					//Check whether the CC Service Charge is correct or not
					if(ccServiceChargeAmt == ccsAmt)
					{
						test.log(LogStatus.PASS, "CC Service Charge value is correct");
					}
					else
					{
						double diff = ccServiceChargeAmt - ccsAmt;
						test.log(LogStatus.FAIL, "CC Service Charge value is different : "+diff);
					}
					
					//Check Whether the Discount is Correct or not
					if(discAmt == disAmt)
					{
						test.log(LogStatus.PASS, "Discount value is correct");
					}
					else
					{
						double diff = discAmt - disAmt;
						test.log(LogStatus.FAIL, "Discount value is different : "+diff);
					}
					
					//Clear the email field
					driver.findElement(By.xpath("//input[@ng-model='saleSummary.email']")).clear();
					//Enter the Required mail id
					driver.findElement(By.xpath("//input[@ng-model='saleSummary.email']")).sendKeys("sappanimuthub@benseron.com");
					
					Thread.sleep(2000);
					//Click the Send Receipt button
					driver.findElement(By.xpath("//button[contains(.,'Send Receipt')]")).click();
					
					Thread.sleep(1500);
					if(driver.findElement(By.xpath("//span[contains(.,'Email receipt sent successfully')]")).getText().equalsIgnoreCase("Email receipt sent successfully"))
					{
						test.log(LogStatus.PASS, "Email receipt sent successfully");
					}
					else
					{
						test.log(LogStatus.FAIL, "Email receipt sent fail");
					}
					
					
					Thread.sleep(2000);
					//Click the Send Receipt button
					driver.findElement(By.xpath("//i[@class='fa fa-file-pdf-o']/../../button/i")).click();
					
					Thread.sleep(2000);
					if(driver.findElement(By.xpath("//span[contains(.,'Payment Receipt sent successfully')]")).getText().equalsIgnoreCase("Payment Receipt sent successfully"))
					{
						test.log(LogStatus.PASS, "Payment receipt sent successfully");
					}
					else
					{
						test.log(LogStatus.FAIL, "Payment receipt sent fail");
					}
					Thread.sleep(3000);
					driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
					Thread.sleep(5000);
					//Click the Back button
					driver.findElement(By.xpath("//button[@class='btn btn-small btn-blue ng-binding']/../a")).click();
					Thread.sleep(3000);
				}
				
				Thread.sleep(3000);
				//Click the Check Number Search option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).clear();
				
				//Close the Service Type
				driver.findElement(By.xpath("//li[@class='search-choice']/a")).click();
			}

			@Test(priority=205)
			public void Sale_Saummary_Sale_method_Report_For_Specific_Date_With_Dynamic_Report(WebDriver driver) throws Exception
			{

				Thread.sleep(3000);
				//Click the Employee option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required employee
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
				/*Thread.sleep(3000);
				//Click the Check Number Search option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).clear();
				//Enter the Check Number
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).sendKeys("0-007");
				*/
				
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
			
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
			
				Thread.sleep(3000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				for(int i = 1; i <= 8; i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}Thread.sleep(3000);
				//Check Whether all the field is selected or not
				if(driver.findElement(By.xpath("//span[contains(.,'Transaction Date')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Net sales')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Total tax amount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Inclusive tax amount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'CC Service Charge')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Gross Receipt')]/../input")).isSelected())
				{
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						//Check whether all the filed is available or not
						if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Transaction Date')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net sales')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Total tax amount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Inclusive tax amount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'CC Service Charge')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Gross Receipt')]")).isDisplayed())
						{
							test.log(LogStatus.PASS, "All the Neccessary fields are displayed");
						}
						else
						{
							test.log(LogStatus.FAIL, "Neccessary fields are not displayed");
						}
						
						//Change the option from enable to Disable the Transaction Date Option
						if(driver.findElement(By.xpath("//span[contains(.,'Transaction Date')]/../input")).isSelected())
						{
							//Click the Enabled Transaction Date Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Transaction Date')]"))).click().build().perform();
							try
							{
								//Check whether the Transaction Date Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Transaction Date')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Transaction Date is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Transaction Date is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Transaction Date Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Net sales Option
						if(driver.findElement(By.xpath("//span[contains(.,'Net sales')]/../input")).isSelected())
						{
							//Click the Enabled Net sales Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Net sales')]"))).click().build().perform();
							try
							{
								//Check whether the Net sales Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net sales')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Net sales is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Net sales is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Net sales Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Total tax amount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Total tax amount')]/../input")).isSelected())
						{
							//Click the Enabled Total tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Total tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Total tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Total tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Total tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Total tax amount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Total tax amount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Inclusive tax amount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Inclusive tax amount')]/../input")).isSelected())
						{
							//Click the Enabled Inclusive tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Inclusive tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Inclusive tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Inclusive tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Inclusive tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Inclusive tax amount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Inclusive tax amount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the CC Service Charge Option
						if(driver.findElement(By.xpath("//span[contains(.,'CC Service Charge')]/../input")).isSelected())
						{
							//Click the Enabled CC Service Charge Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'CC Service Charge')]"))).click().build().perform();
							try
							{
								//Check whether the CC Service Charge Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'CC Service Charge')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "CC Service Charge is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "CC Service Charge is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "CC Service Charge Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Discount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
						{
							//Click the Enabled Discount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
							try
							{
								//Check whether the Discount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Discount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Discount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Discount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Gross Receipt Option
						if(driver.findElement(By.xpath("//span[contains(.,'Gross Receipt')]/../input")).isSelected())
						{
							//Click the Enabled Gross Receipt Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Gross Receipt')]"))).click().build().perform();
							try
							{
								//Check whether the Gross Receipt Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Gross Receipt')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Gross Receipt is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Gross Receipt is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Gross Receipt Option is Disabled When user enter the required date for date range");
						}
						
						//Enable the Transaction Date Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Transaction Date')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Transaction Date Option is Enabled after user click(Disable) the Transaction Date option");

						}
						else
						{
							//Click the Enabled Transaction Date Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Transaction Date')]"))).click().build().perform();
							try
							{
								//Check whether the Transaction Date Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Transaction Date')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Transaction Date is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Transaction Date is not displayed");
							}				
						}
						
						//Enable the Net sales Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Net sales')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Net sales Option is Enabled after user click(Disable) the Net Sales option");

						}
						else
						{
							//Click the Enabled Net sales Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Net sales')]"))).click().build().perform();
							try
							{
								//Check whether the Net sales Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net sales')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Net sales is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Net sales is not displayed");
							}				
						}
						
						//Enable the Total tax amount Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Total tax amount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Total tax amount Option is Enabled after user click(Disable) the Total tax amount option");

						}
						else
						{
							//Click the Enabled Total tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Total tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Total tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Total tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Total tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Total tax amount is not displayed");
							}				
						}
						
						//Enable the Inclusive tax amount Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Inclusive tax amount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Inclusive tax amount Option is Enabled after user click(Disable) the Inclusive tax amount option");

						}
						else
						{
							//Click the Enabled Inclusive tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Inclusive tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Inclusive tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Inclusive tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Inclusive tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Inclusive tax amount is not displayed");
							}				
						}
						
						//Enable the CC Service Charge Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'CC Service Charge')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "CC Service Charge Option is Enabled after user click(Disable) the CC Service Charge option");

						}
						else
						{
							//Click the Enabled CC Service Charge Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'CC Service Charge')]"))).click().build().perform();
							try
							{
								//Check whether the CC Service Charge Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'CC Service Charge')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "CC Service Charge is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "CC Service Charge is not displayed");
							}				
						}
												
						//Disable the required option from enable to disable Discount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Discount Option is Enabled after user click(Disable) the Discount option");

						}
						else
						{

							//Click the Enabled Discount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
							try
							{
								//Check whether the Discount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Discount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Discount is not displayed");
							}
						}
						
						//Disable the required option from enable to disable Gross Receipt Option
						if(driver.findElement(By.xpath("//span[contains(.,'Gross Receipt')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Gross Receipt Option is Enabled after user click(Disable) the Gross Receipt option");

						}
						else
						{

							//Click the Enabled Gross Receipt Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Gross Receipt')]"))).click().build().perform();
							try
							{
								//Check whether the Gross Receipt Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Gross Receipt')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Gross Receipt is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Gross Receipt is not displayed");
							}
						}
		
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for the Required Date Range");
					}
					
				}
				else
				{
					test.log(LogStatus.FAIL, "All dynamic option is not selected");
				}
				
			}

			@Test(priority=206)
			public void Sale_Saummary_Sale_method_Report_For_Specific_Date_WithService_Type_And_Dynamic_Report(WebDriver driver) throws Exception
			{
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				Thread.sleep(3000);
				//Click the Employee option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required employee
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
			    
				/*Thread.sleep(3000);
				//Click the Check Number Search option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).clear();
				//Enter the Check Number
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).sendKeys("0-007");
				*/
				
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
			
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				Thread.sleep(3000);
				//Click the OrderType 		
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul")).click();
				Thread.sleep(3000);
				//Enter the Service_Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Utility.getReportProperty("Service_Type"));
				
				Thread.sleep(3000);
				//Press the Service Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
				
				//Enter the Service_Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys("QSR");
				
				Thread.sleep(3000);
				//Press the Service Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
				//Enter the Service_Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys("Web - DELIVERY");
				
				Thread.sleep(3000);
				//Press the Service Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

				Thread.sleep(3000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				for(int i = 1; i <= 8; i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}Thread.sleep(3000);
				//Check Whether all the field is selected or not
				if(driver.findElement(By.xpath("//span[contains(.,'Transaction Date')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Net sales')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Total tax amount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Inclusive tax amount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'CC Service Charge')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Gross Receipt')]/../input")).isSelected())
				{
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						//Check whether all the filed is available or not
						if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Transaction Date')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net sales')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Total tax amount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Inclusive tax amount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'CC Service Charge')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Gross Receipt')]")).isDisplayed())
						{
							test.log(LogStatus.PASS, "All the Neccessary fields are displayed");
						}
						else
						{
							test.log(LogStatus.FAIL, "Neccessary fields are not displayed");
						}
						
						//Change the option from enable to Disable the Transaction Date Option
						if(driver.findElement(By.xpath("//span[contains(.,'Transaction Date')]/../input")).isSelected())
						{
							//Click the Enabled Transaction Date Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Transaction Date')]"))).click().build().perform();
							try
							{
								//Check whether the Transaction Date Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Transaction Date')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Transaction Date is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Transaction Date is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Transaction Date Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Net sales Option
						if(driver.findElement(By.xpath("//span[contains(.,'Net sales')]/../input")).isSelected())
						{
							//Click the Enabled Net sales Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Net sales')]"))).click().build().perform();
							try
							{
								//Check whether the Net sales Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net sales')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Net sales is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Net sales is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Net sales Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Total tax amount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Total tax amount')]/../input")).isSelected())
						{
							//Click the Enabled Total tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Total tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Total tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Total tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Total tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Total tax amount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Total tax amount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Inclusive tax amount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Inclusive tax amount')]/../input")).isSelected())
						{
							//Click the Enabled Inclusive tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Inclusive tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Inclusive tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Inclusive tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Inclusive tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Inclusive tax amount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Inclusive tax amount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the CC Service Charge Option
						if(driver.findElement(By.xpath("//span[contains(.,'CC Service Charge')]/../input")).isSelected())
						{
							//Click the Enabled CC Service Charge Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'CC Service Charge')]"))).click().build().perform();
							try
							{
								//Check whether the CC Service Charge Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'CC Service Charge')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "CC Service Charge is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "CC Service Charge is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "CC Service Charge Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Discount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
						{
							//Click the Enabled Discount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
							try
							{
								//Check whether the Discount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Discount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Discount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Discount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Gross Receipt Option
						if(driver.findElement(By.xpath("//span[contains(.,'Gross Receipt')]/../input")).isSelected())
						{
							//Click the Enabled Gross Receipt Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Gross Receipt')]"))).click().build().perform();
							try
							{
								//Check whether the Gross Receipt Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Gross Receipt')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Gross Receipt is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Gross Receipt is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Gross Receipt Option is Disabled When user enter the required date for date range");
						}
						
						//Enable the Transaction Date Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Transaction Date')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Transaction Date Option is Enabled after user click(Disable) the Transaction Date option");

						}
						else
						{
							//Click the Enabled Transaction Date Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Transaction Date')]"))).click().build().perform();
							try
							{
								//Check whether the Transaction Date Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Transaction Date')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Transaction Date is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Transaction Date is not displayed");
							}				
						}
						
						//Enable the Net sales Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Net sales')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Net sales Option is Enabled after user click(Disable) the Net Sales option");

						}
						else
						{
							//Click the Enabled Net sales Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Net sales')]"))).click().build().perform();
							try
							{
								//Check whether the Net sales Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net sales')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Net sales is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Net sales is not displayed");
							}				
						}
						
						//Enable the Total tax amount Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Total tax amount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Total tax amount Option is Enabled after user click(Disable) the Total tax amount option");

						}
						else
						{
							//Click the Enabled Total tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Total tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Total tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Total tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Total tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Total tax amount is not displayed");
							}				
						}
						
						//Enable the Inclusive tax amount Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Inclusive tax amount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Inclusive tax amount Option is Enabled after user click(Disable) the Inclusive tax amount option");

						}
						else
						{
							//Click the Enabled Inclusive tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Inclusive tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Inclusive tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Inclusive tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Inclusive tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Inclusive tax amount is not displayed");
							}				
						}
						
						//Enable the CC Service Charge Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'CC Service Charge')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "CC Service Charge Option is Enabled after user click(Disable) the CC Service Charge option");

						}
						else
						{
							//Click the Enabled CC Service Charge Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'CC Service Charge')]"))).click().build().perform();
							try
							{
								//Check whether the CC Service Charge Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'CC Service Charge')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "CC Service Charge is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "CC Service Charge is not displayed");
							}				
						}
												
						//Disable the required option from enable to disable Discount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Discount Option is Enabled after user click(Disable) the Discount option");

						}
						else
						{

							//Click the Enabled Discount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
							try
							{
								//Check whether the Discount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Discount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Discount is not displayed");
							}
						}
						
						//Disable the required option from enable to disable Gross Receipt Option
						if(driver.findElement(By.xpath("//span[contains(.,'Gross Receipt')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Gross Receipt Option is Enabled after user click(Disable) the Gross Receipt option");

						}
						else
						{

							//Click the Enabled Gross Receipt Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Gross Receipt')]"))).click().build().perform();
							try
							{
								//Check whether the Gross Receipt Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Gross Receipt')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Gross Receipt is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Gross Receipt is not displayed");
							}
						}
		
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for the Required Date Range");
					}
					
				}
				else
				{
					test.log(LogStatus.FAIL, "All dynamic option is not selected");
				}
				
				Thread.sleep(3000);
				//Close the Service Type
				driver.findElement(By.xpath("//li[@class='search-choice']/a")).click();

			}

			@Test(priority=207)
			public void Sale_Saummary_Sale_method_Report_For_Specific_Date_WithSearch_And_Dynamic_Report(WebDriver driver) throws Exception
			{
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				Thread.sleep(3000);
				//Click the Employee option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required employee
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);	
				
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
			
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
						
				List<WebElement> close = driver.findElements(By.xpath("//label[.='Service Type']/../div/ul/li/a"));
				for(int i = 1; i <= close.size(); i++)
				{
					driver.findElement(By.xpath("//label[.='Service Type']/../div/ul/li["+i+"]/a")).click();
				}
				
				Thread.sleep(3000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				for(int i = 1; i <= 8; i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}Thread.sleep(3000);
				//Check Whether all the field is selected or not
				if(driver.findElement(By.xpath("//span[contains(.,'Transaction Date')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Net sales')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Total tax amount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Inclusive tax amount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'CC Service Charge')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Gross Receipt')]/../input")).isSelected())
				{
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						//Check whether all the filed is available or not
						if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Transaction Date')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net sales')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Total tax amount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Inclusive tax amount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'CC Service Charge')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Gross Receipt')]")).isDisplayed())
						{
							test.log(LogStatus.PASS, "All the Neccessary fields are displayed");
						}
						else
						{
							test.log(LogStatus.FAIL, "Neccessary fields are not displayed");
						}
						
						//Change the option from enable to Disable the Transaction Date Option
						if(driver.findElement(By.xpath("//span[contains(.,'Transaction Date')]/../input")).isSelected())
						{
							//Click the Enabled Transaction Date Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Transaction Date')]"))).click().build().perform();
							try
							{
								//Check whether the Transaction Date Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Transaction Date')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Transaction Date is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Transaction Date is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Transaction Date Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Net sales Option
						if(driver.findElement(By.xpath("//span[contains(.,'Net sales')]/../input")).isSelected())
						{
							//Click the Enabled Net sales Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Net sales')]"))).click().build().perform();
							try
							{
								//Check whether the Net sales Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net sales')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Net sales is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Net sales is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Net sales Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Total tax amount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Total tax amount')]/../input")).isSelected())
						{
							//Click the Enabled Total tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Total tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Total tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Total tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Total tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Total tax amount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Total tax amount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Inclusive tax amount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Inclusive tax amount')]/../input")).isSelected())
						{
							//Click the Enabled Inclusive tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Inclusive tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Inclusive tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Inclusive tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Inclusive tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Inclusive tax amount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Inclusive tax amount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the CC Service Charge Option
						if(driver.findElement(By.xpath("//span[contains(.,'CC Service Charge')]/../input")).isSelected())
						{
							//Click the Enabled CC Service Charge Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'CC Service Charge')]"))).click().build().perform();
							try
							{
								//Check whether the CC Service Charge Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'CC Service Charge')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "CC Service Charge is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "CC Service Charge is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "CC Service Charge Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Discount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
						{
							//Click the Enabled Discount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
							try
							{
								//Check whether the Discount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Discount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Discount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Discount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Gross Receipt Option
						if(driver.findElement(By.xpath("//span[contains(.,'Gross Receipt')]/../input")).isSelected())
						{
							//Click the Enabled Gross Receipt Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Gross Receipt')]"))).click().build().perform();
							try
							{
								//Check whether the Gross Receipt Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Gross Receipt')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Gross Receipt is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Gross Receipt is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Gross Receipt Option is Disabled When user enter the required date for date range");
						}
						
						//Enable the Transaction Date Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Transaction Date')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Transaction Date Option is Enabled after user click(Disable) the Transaction Date option");

						}
						else
						{
							//Click the Enabled Transaction Date Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Transaction Date')]"))).click().build().perform();
							try
							{
								//Check whether the Transaction Date Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Transaction Date')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Transaction Date is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Transaction Date is not displayed");
							}				
						}
						
						//Enable the Net sales Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Net sales')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Net sales Option is Enabled after user click(Disable) the Net Sales option");

						}
						else
						{
							//Click the Enabled Net sales Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Net sales')]"))).click().build().perform();
							try
							{
								//Check whether the Net sales Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net sales')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Net sales is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Net sales is not displayed");
							}				
						}
						
						//Enable the Total tax amount Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Total tax amount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Total tax amount Option is Enabled after user click(Disable) the Total tax amount option");

						}
						else
						{
							//Click the Enabled Total tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Total tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Total tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Total tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Total tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Total tax amount is not displayed");
							}				
						}
						
						//Enable the Inclusive tax amount Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Inclusive tax amount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Inclusive tax amount Option is Enabled after user click(Disable) the Inclusive tax amount option");

						}
						else
						{
							//Click the Enabled Inclusive tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Inclusive tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Inclusive tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Inclusive tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Inclusive tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Inclusive tax amount is not displayed");
							}				
						}
						
						//Enable the CC Service Charge Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'CC Service Charge')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "CC Service Charge Option is Enabled after user click(Disable) the CC Service Charge option");

						}
						else
						{
							//Click the Enabled CC Service Charge Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'CC Service Charge')]"))).click().build().perform();
							try
							{
								//Check whether the CC Service Charge Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'CC Service Charge')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "CC Service Charge is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "CC Service Charge is not displayed");
							}				
						}
												
						//Disable the required option from enable to disable Discount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Discount Option is Enabled after user click(Disable) the Discount option");

						}
						else
						{

							//Click the Enabled Discount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
							try
							{
								//Check whether the Discount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Discount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Discount is not displayed");
							}
						}
						
						//Disable the required option from enable to disable Gross Receipt Option
						if(driver.findElement(By.xpath("//span[contains(.,'Gross Receipt')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Gross Receipt Option is Enabled after user click(Disable) the Gross Receipt option");

						}
						else
						{

							//Click the Enabled Gross Receipt Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Gross Receipt')]"))).click().build().perform();
							try
							{
								//Check whether the Gross Receipt Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Gross Receipt')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Gross Receipt is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Gross Receipt is not displayed");
							}
						}
		
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for the Required Date Range");
					}
					
				}
				else
				{
					test.log(LogStatus.FAIL, "All dynamic option is not selected");
				}
				
				Thread.sleep(3000);
				//Click the Check Number Search option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).clear();
				
				Thread.sleep(3000);
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);Thread.sleep(3000);
			}

			@Test(priority=208)
			public void Sale_Saummary_Sale_method_Report_For_Specific_Date_WithSearchAndServiceType_And_Dynamic_Report(WebDriver driver) throws Exception
			{
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				Thread.sleep(3000);
				//Click the Employee option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required employee
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys("All");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);	
				
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/a")).click();
				//Enter the required Time Period
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));
			
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).clear();
				//Enter the date
				driver.findElement(By.xpath("//form[@name='saleReport']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
						
				Thread.sleep(3000);
				//Click the OrderType 		
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul")).click();
				Thread.sleep(3000);
				//Enter the Service_Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys("QSR");
				
				Thread.sleep(3000);
				//Press the Service Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

				Thread.sleep(3000);
				//Enter the Service_Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys("Phone - DELIVERY");
				
				Thread.sleep(3000);
				//Press the Service Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);

				Thread.sleep(3000);
				//Enter the Service_Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys("Web - DELIVERY");
				
				Thread.sleep(3000);
				//Press the Service Type
				driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
				
				Thread.sleep(3000);
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(3000);
				for(int i = 1; i <= 8; i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}Thread.sleep(3000);
				//Check Whether all the field is selected or not
				if(driver.findElement(By.xpath("//span[contains(.,'Transaction Date')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Net sales')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Total tax amount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Inclusive tax amount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'CC Service Charge')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected()
						&&driver.findElement(By.xpath("//span[contains(.,'Gross Receipt')]/../input")).isSelected())
				{
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						//Check whether all the filed is available or not
						if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Transaction Date')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net sales')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Total tax amount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Inclusive tax amount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'CC Service Charge')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed()
								&&driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Gross Receipt')]")).isDisplayed())
						{
							test.log(LogStatus.PASS, "All the Neccessary fields are displayed");
						}
						else
						{
							test.log(LogStatus.FAIL, "Neccessary fields are not displayed");
						}
						
						//Change the option from enable to Disable the Transaction Date Option
						if(driver.findElement(By.xpath("//span[contains(.,'Transaction Date')]/../input")).isSelected())
						{
							//Click the Enabled Transaction Date Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Transaction Date')]"))).click().build().perform();
							try
							{
								//Check whether the Transaction Date Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Transaction Date')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Transaction Date is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Transaction Date is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Transaction Date Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Net sales Option
						if(driver.findElement(By.xpath("//span[contains(.,'Net sales')]/../input")).isSelected())
						{
							//Click the Enabled Net sales Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Net sales')]"))).click().build().perform();
							try
							{
								//Check whether the Net sales Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net sales')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Net sales is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Net sales is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Net sales Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Total tax amount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Total tax amount')]/../input")).isSelected())
						{
							//Click the Enabled Total tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Total tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Total tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Total tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Total tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Total tax amount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Total tax amount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Inclusive tax amount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Inclusive tax amount')]/../input")).isSelected())
						{
							//Click the Enabled Inclusive tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Inclusive tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Inclusive tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Inclusive tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Inclusive tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Inclusive tax amount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Inclusive tax amount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the CC Service Charge Option
						if(driver.findElement(By.xpath("//span[contains(.,'CC Service Charge')]/../input")).isSelected())
						{
							//Click the Enabled CC Service Charge Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'CC Service Charge')]"))).click().build().perform();
							try
							{
								//Check whether the CC Service Charge Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'CC Service Charge')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "CC Service Charge is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "CC Service Charge is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "CC Service Charge Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Discount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
						{
							//Click the Enabled Discount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
							try
							{
								//Check whether the Discount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Discount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Discount is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Discount Option is Disabled When user enter the required date for date range");
						}
						
						//Change the option from enable to Disable the Gross Receipt Option
						if(driver.findElement(By.xpath("//span[contains(.,'Gross Receipt')]/../input")).isSelected())
						{
							//Click the Enabled Gross Receipt Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Gross Receipt')]"))).click().build().perform();
							try
							{
								//Check whether the Gross Receipt Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Gross Receipt')]")).isDisplayed())
								{
									test.log(LogStatus.FAIL, "Gross Receipt is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.PASS, "Gross Receipt is not displayed");
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "Gross Receipt Option is Disabled When user enter the required date for date range");
						}
						
						//Enable the Transaction Date Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Transaction Date')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Transaction Date Option is Enabled after user click(Disable) the Transaction Date option");

						}
						else
						{
							//Click the Enabled Transaction Date Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Transaction Date')]"))).click().build().perform();
							try
							{
								//Check whether the Transaction Date Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Transaction Date')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Transaction Date is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Transaction Date is not displayed");
							}				
						}
						
						//Enable the Net sales Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Net sales')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Net sales Option is Enabled after user click(Disable) the Net Sales option");

						}
						else
						{
							//Click the Enabled Net sales Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Net sales')]"))).click().build().perform();
							try
							{
								//Check whether the Net sales Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Net sales')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Net sales is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Net sales is not displayed");
							}				
						}
						
						//Enable the Total tax amount Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Total tax amount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Total tax amount Option is Enabled after user click(Disable) the Total tax amount option");

						}
						else
						{
							//Click the Enabled Total tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Total tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Total tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Total tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Total tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Total tax amount is not displayed");
							}				
						}
						
						//Enable the Inclusive tax amount Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'Inclusive tax amount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Inclusive tax amount Option is Enabled after user click(Disable) the Inclusive tax amount option");

						}
						else
						{
							//Click the Enabled Inclusive tax amount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Inclusive tax amount')]"))).click().build().perform();
							try
							{
								//Check whether the Inclusive tax amount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Inclusive tax amount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Inclusive tax amount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Inclusive tax amount is not displayed");
							}				
						}
						
						//Enable the CC Service Charge Option if it is in disabled status
						if(driver.findElement(By.xpath("//span[contains(.,'CC Service Charge')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "CC Service Charge Option is Enabled after user click(Disable) the CC Service Charge option");

						}
						else
						{
							//Click the Enabled CC Service Charge Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'CC Service Charge')]"))).click().build().perform();
							try
							{
								//Check whether the CC Service Charge Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'CC Service Charge')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "CC Service Charge is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "CC Service Charge is not displayed");
							}				
						}
												
						//Disable the required option from enable to disable Discount Option
						if(driver.findElement(By.xpath("//span[contains(.,'Discount')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Discount Option is Enabled after user click(Disable) the Discount option");

						}
						else
						{

							//Click the Enabled Discount Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Discount')]"))).click().build().perform();
							try
							{
								//Check whether the Discount Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Discount')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Discount is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Discount is not displayed");
							}
						}
						
						//Disable the required option from enable to disable Gross Receipt Option
						if(driver.findElement(By.xpath("//span[contains(.,'Gross Receipt')]/../input")).isSelected())
						{
							test.log(LogStatus.FAIL, "Gross Receipt Option is Enabled after user click(Disable) the Gross Receipt option");

						}
						else
						{

							//Click the Enabled Gross Receipt Option
							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath("//input/../span[contains(.,'Gross Receipt')]"))).click().build().perform();
							try
							{
								//Check whether the Gross Receipt Option is displayed or not
								if(driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/thead/tr[1]/th/div/span[contains(.,'Gross Receipt')]")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Gross Receipt is displayed");
								}
							}
							catch(Exception e)
							{
								test.log(LogStatus.FAIL, "Gross Receipt is not displayed");
							}
						}
		
					}
					else
					{
						test.log(LogStatus.FAIL, "Table Format Report is not available for the Required Date Range");
					}
					
				}
				else
				{
					test.log(LogStatus.FAIL, "All dynamic option is not selected");
				}
				
				Thread.sleep(3000);
				//Click the Check Number Search option
				//driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/input")).clear();
				
				//Close the Service Type
				//driver.findElement(By.xpath("//li[@class='search-choice']/a")).click();
				Thread.sleep(3000);
			}
			
		}
	
		