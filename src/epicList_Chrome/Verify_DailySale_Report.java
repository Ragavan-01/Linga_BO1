package epicList_Chrome;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
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

import epicList_Chrome.Utility;
import newReadExcelFile_New.ExcelDataConfig;

public class Verify_DailySale_Report {

	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Verify_DailySale_Report");

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
			Thread.sleep(2000);
			// Call the chrome driver by using local path
			System.setProperty("webdriver.chrome.driver", Utility.getProperty("Chrome_Driver_Path"));
			// Open the Chrome window
			driver = new ChromeDriver();
			// Wait for 30 seconds
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// Maximize the Chrome window
			driver.manage().window().maximize();
			Thread.sleep(1000);
			// Launch the URL
			driver.get(Utility.getProperty("appURL"));
			if (Utility.getProperty("Product").equalsIgnoreCase("UPOS")) {
				Browser a = new Browser();
				a.UPOS_login(driver, test);
			} else {
				Browser a = new Browser();
				a.Linga_login(driver, test);
			}
		}

		@Test(priority = 500)
		public void logout() throws Exception {
			Browser a = new Browser();
			a.Logout(driver, test);
		}	
	
		@Test(priority = 100)
		public void calling() throws Exception
		{
			Thread.sleep(10000);
			try
			{
					Thread.sleep(1000);System.out.println("Minimize Chat Icon");
					driver.findElement(By.id("zsiq_minimize")).click();			
			}
			catch(Exception e)
			{
				System.out.println("Minimize Chat Icon Missing");
			}
			//ViewDashBoardReports a = new ViewDashBoardReports();
			Thread.sleep(1000);
			Daily_Sale_method_openpage_Report(driver);
			Daily_Sale_method_Report_For_Specific_Date(driver);
			Daily_Sale_method_Report_For_Specific_Date_With_Dynamic_Report(driver);
			Thread.sleep(1500);
		}
	
	@Test(priority=120,enabled = false)
	public void Daily_Sale_method_openpage_Report(WebDriver driver) throws Exception
			{
		File src = new File(Utility.getProperty("Excel_Sheet_Path_For_Xpath"));
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 = wb.getSheetAt(1);sheet1.getLastRowNum();
		
		ExcelDataConfig excel = new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_For_Xpath"));
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
				if(driver.findElement(By.xpath(excel.getData(3, 1074, 1))).getText().equalsIgnoreCase("Daily Sale"))
				{
					test.log(LogStatus.PASS, "Daily Sale Sale Report page loaded successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Daily Sale Sale Report page loaded fail");
				}

				Thread.sleep(3000);wb.close();

			}
			
	@Test(priority=121,enabled = false)
	public void Daily_Sale_method_Report_For_Specific_Date(WebDriver driver) throws Exception
	{          
        File src = new File(Utility.getProperty("Excel_Sheet_Path_For_Xpath"));
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 = wb.getSheetAt(1);sheet1.getLastRowNum();
		
		ExcelDataConfig excel = new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_For_Xpath"));
				Thread.sleep(2000);
				WebElement html = driver.findElement(By.tagName("html"));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
		
				Thread.sleep(3000);
				//Click the Time Period option
				driver.findElement(By.xpath(excel.getData(3, 1536, 1))).click();
				//Enter the required Time Period
				driver.findElement(By.xpath(excel.getData(3, 1537, 1))).sendKeys("Date Range");
				//Press the Enter Key
				driver.findElement(By.xpath(excel.getData(3, 1537, 1))).sendKeys(Keys.ENTER);
				
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath(excel.getData(3, 1075, 1))).clear();
				//Enter the date
				driver.findElement(By.xpath(excel.getData(3, 1075, 1))).sendKeys(Utility.getReportProperty("Date_Range_From"));
		
				Thread.sleep(2000);
				//Clear the date field
				driver.findElement(By.xpath(excel.getData(3, 1076, 1))).clear();
				//Enter the date
				driver.findElement(By.xpath(excel.getData(3, 1076, 1))).sendKeys(Utility.getReportProperty("Date_Range_To"));
				
				Thread.sleep(2000);
				//Click the Run Button
				driver.findElement(By.xpath(excel.getData(3, 572, 1))).click();
				
				Thread.sleep(3000);
				try
				{
					//Check weather the report is available for the selected time period
					if(driver.findElement(By.xpath(excel.getData(3, 704, 1))).isDisplayed())
					{
						test.log(LogStatus.FAIL, "Daily Sale Report is not available for Specific Date");
					}
				}
				catch(Exception fd)
				{
					test.log(LogStatus.PASS, "Daily Sale Report available for Specific Date");
					
					Thread.sleep(3000);
					//Check Weather the Top 5 daily sale available or not
					if(driver.findElement(By.xpath(excel.getData(3, 705, 1))).isDisplayed())
					{
						test.log(LogStatus.PASS, "Here Top 5 Daily Sale Report available for Specific Date");
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath(excel.getData(3, 706, 1))).click();
						Thread.sleep(1000);
						
						//Click the Pie chart option
						driver.findElement(By.xpath(excel.getData(3, 707, 1))).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Pie Chart available");
						Thread.sleep(3000);
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath(excel.getData(3, 706, 1))).click();
						Thread.sleep(1000);
		
						//Click the Polar Area chart option
						driver.findElement(By.xpath(excel.getData(3, 708, 1))).click();
						Thread.sleep(2000);
						test.log(LogStatus.INFO, "There is Polar Area Chart available");
						Thread.sleep(3000);
						
						Thread.sleep(2000);
						//Click the down arrow button of chart type
						driver.findElement(By.xpath(excel.getData(3, 706, 1))).click();
						Thread.sleep(1000);
		
						//Click the Bar chart option
						driver.findElement(By.xpath(excel.getData(3, 709, 1))).click();
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
					if(driver.findElement(By.xpath(excel.getData(3, 710, 1))).isDisplayed())
					{
						test.log(LogStatus.PASS, "There is Graphical type of Daily sale report is available for Specific Date");
					}
					else
					{
						test.log(LogStatus.FAIL, "Graphical report is not available for Specific Date");
					}
					
					Thread.sleep(5000);
					
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath(excel.getData(3, 1077, 1))).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for Specific Date");
						
						Thread.sleep(3000);
				        //No.of rows
				        List<WebElement> rows = driver.findElements(By.xpath (excel.getData(3, 1078, 1)));
				        
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
						test.log(LogStatus.FAIL, "Table Format Report is not available for Specific Date");wb.close();
					}
				}
			}
		
	@Test(priority=122,enabled = false)
	public void Daily_Sale_method_Report_For_Specific_Date_With_Dynamic_Report(WebDriver driver) throws Exception
	{        
		    File src = new File(Utility.getProperty("Excel_Sheet_Path_For_Xpath"));
			
			FileInputStream fis = new FileInputStream(src);
			
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			XSSFSheet sheet1 = wb.getSheetAt(1);sheet1.getLastRowNum();
			
			ExcelDataConfig excel = new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_For_Xpath"));
			Thread.sleep(2000);
			WebElement html = driver.findElement(By.tagName("html"));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	
			Thread.sleep(3000);
			//Click the Time Period option
			driver.findElement(By.xpath(excel.getData(3, 1536, 1))).click();
			//Enter the required Time Period
			driver.findElement(By.xpath(excel.getData(3, 1537, 1))).sendKeys("Date Range");
			//Press the Enter Key
			driver.findElement(By.xpath(excel.getData(3, 1537, 1))).sendKeys(Keys.ENTER);
			
			Thread.sleep(2000);
			//Clear the date field
			driver.findElement(By.xpath(excel.getData(3,1075, 1))).clear();
			//Enter the date
			driver.findElement(By.xpath(excel.getData(3,1075, 1))).sendKeys(Utility.getReportProperty("Date_Range_From"));
	
			Thread.sleep(2000);
			//Clear the date field
			driver.findElement(By.xpath(excel.getData(3,1076, 1))).clear();
			//Enter the date
			driver.findElement(By.xpath(excel.getData(3,1076, 1))).sendKeys(Utility.getReportProperty("Date_Range_To"));
			
			Thread.sleep(2000);
			//Click the Run Button
			driver.findElement(By.xpath(excel.getData(3,572, 1))).click();
			
			Thread.sleep(3000);
			for(int i = 1; i <= 8; i++)
			{
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			}Thread.sleep(3000);
			
			try
			{
				if(driver.findElement(By.xpath(excel.getData(3,704, 1))).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Daily Sale Report is not available for the Required Date Range");
				}
			}
			catch(Exception fd)
			{
				//Check Whether all the field is selected or not
				if(driver.findElement(By.xpath(excel.getData(3,1083, 1))).isSelected()
						&&driver.findElement(By.xpath(excel.getData(3,1084, 1))).isSelected()
						&&driver.findElement(By.xpath(excel.getData(3,1085, 1))).isSelected()
						&&driver.findElement(By.xpath(excel.getData(3,1086, 1))).isSelected())
				{
					//Check weather the table format report is available or not
					if(driver.findElement(By.xpath(excel.getData(3,1077, 1))).isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Format Report is available for the Required Date Range");
						
						//Check whether all the filed is available or not
						if(driver.findElement(By.xpath(excel.getData(3,1087, 1))).isDisplayed()
								&&driver.findElement(By.xpath(excel.getData(3,1088, 1))).isDisplayed()
								&&driver.findElement(By.xpath(excel.getData(3,1089, 1))).isDisplayed()
								&&driver.findElement(By.xpath(excel.getData(3,1090, 1))).isDisplayed())
						{
							test.log(LogStatus.PASS, "All the Neccessary fields are displayed");
						}
						else
						{
							test.log(LogStatus.FAIL, "Neccessary fields are not displayed");
						}
						
						//Change the option from enable to Disable the Net Sale Option
						if(driver.findElement(By.xpath(excel.getData(3,1083, 1))).isSelected())
						{
							
							//Click the Enabled Net Sale Option
						driver.findElement(By.xpath(excel.getData(2, 5, 1))).click();
							/*	Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath(excel.getData(3,1083, 1)))).click().build().perform();
					*/		try
							{
								//Check whether the Net Sale Option is displayed or not
								if(driver.findElement(By.xpath(excel.getData(3,1087, 1))).isDisplayed())
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
						if(driver.findElement(By.xpath(excel.getData(3,1084, 1))).isSelected())
						{
							//Click the Enabled Tax Option
							driver.findElement(By.xpath(excel.getData(2, 6, 1))).click();
/*							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath(excel.getData(3,1084, 1)))).click().build().perform();
	*/						try
							{
								//Check whether the Tax Option is displayed or not
								if(driver.findElement(By.xpath(excel.getData(3,1088, 1))).isDisplayed())
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
						if(driver.findElement(By.xpath(excel.getData(3,1085, 1))).isSelected())
						{
							//Click the Enabled Discount Option
							driver.findElement(By.xpath(excel.getData(2, 7, 1))).click();
							/*Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath(excel.getData(3,1085, 1)))).click().build().perform();
						*/	try
							{
								//Check whether the Discount Option is displayed or not
								if(driver.findElement(By.xpath(excel.getData(3,1089, 1))).isDisplayed())
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
						if(driver.findElement(By.xpath(excel.getData(3,1086, 1))).isSelected())
						{
							//Click the Enabled Grand Sale Option
							driver.findElement(By.xpath(excel.getData(2, 8, 1))).click();
						/*	Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath(excel.getData(3,1086, 1)))).click().build().perform();
						*/	try
							{
								//Check whether the Grand Sale Option is displayed or not
								if(driver.findElement(By.xpath(excel.getData(3,1090, 1))).isDisplayed())
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
						if(driver.findElement(By.xpath(excel.getData(3,1083, 1))).isSelected())
						{
							test.log(LogStatus.FAIL, "Net Sale Option is Enabled after user click(Disable) the Net Sale option");
		
						}
						else
						{
							//Click the Enabled Net Sale Option
							driver.findElement(By.xpath(excel.getData(2, 5, 1))).click();
							/*			Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath(excel.getData(3,1083, 1)))).click().build().perform();
					*/		try
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
						if(driver.findElement(By.xpath(excel.getData(3,1084, 1))).isSelected())
						{
							test.log(LogStatus.FAIL, "Tax Option is Enabled after user click(Disable) the Tax option");
		
						}
						else
						{
							//Click the Enabled Tax Option
							driver.findElement(By.xpath(excel.getData(2, 6, 1))).click();
/*							Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath(excel.getData(3,1084, 1)))).click().build().perform();
	*/						try
							{
								//Check whether the Tax Option is displayed or not
								if(driver.findElement(By.xpath(excel.getData(3,1088, 1))).isDisplayed())
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
						if(driver.findElement(By.xpath(excel.getData(3,1085, 1))).isSelected())
						{
							test.log(LogStatus.FAIL, "Discount Option is Enabled after user click(Disable) the Discount option");
		
						}
						else
						{
		
							//Click the Enabled Discount Option
							driver.findElement(By.xpath(excel.getData(2, 7, 1))).click();
					/*		Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath(excel.getData(3,1085, 1)))).click().build().perform();
						*/	try
							{
								//Check whether the Discount Option is displayed or not
								if(driver.findElement(By.xpath(excel.getData(3,1089, 1))).isDisplayed())
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
						if(driver.findElement(By.xpath(excel.getData(3,1086, 1))).isSelected())
						{
							test.log(LogStatus.FAIL, "Grand Sale Option is Enabled after user click(Disable) the Grand Sale option");
		
						}
						else
						{
		
							//Click the Enabled Grand Sale Option
							driver.findElement(By.xpath(excel.getData(2, 8, 1))).click();
							/*Actions act = new Actions(driver);
							act.moveToElement(driver.findElement(By.xpath(excel.getData(3,1086, 1)))).click().build().perform();
						*/	try
							{
								//Check whether the Grand Sale Option is displayed or not
								if(driver.findElement(By.xpath(excel.getData(3,1090, 1))).isDisplayed())
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
					test.log(LogStatus.FAIL, "All dynamic option is not selected");wb.close();
				}
			}			
		}

}
