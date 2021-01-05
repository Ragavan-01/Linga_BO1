package templates;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class Diff {
	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Sale Using Fast Cash");
	
	
	@AfterClass
	public void flushTest() throws Exception
	{
		Thread.sleep(2000);
		rep.endTest(test);
		rep.flush();
		
		//SendMail.snedMailWithExcelAttachment();
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
			driver.findElement(By.name("emailId")).sendKeys("admin@austinfiregrill.com");
			Thread.sleep(1000);
			//Clear the password from the password text box
			driver.findElement(By.name("password")).clear();
			//Enter the password
			driver.findElement(By.name("password")).sendKeys("linga123");
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
			Thread.sleep(10000);
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
			if(Utility.getProperty("Substore_OR_Multistore").equalsIgnoreCase("Multi"))
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
				driver.findElement(By.name("txtusername")).sendKeys("admin@austinfiregrill.com");
				//Clear the password from the password text box
				driver.findElement(By.name("txtpassword")).clear();
				//Enter the password
				driver.findElement(By.name("txtpassword")).sendKeys("linga123");
				Thread.sleep(4000);

				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
			
				//Click the login button
				driver.findElement(By.name("submitlogin")).click();Thread.sleep(8000);
				//Check if we logged in or not
				if(driver.findElement(By.xpath("//div[@id='navigation']/ul[1]/li/a")).getText().equalsIgnoreCase("My Stores"))
				{
					test.log(LogStatus.PASS, "User Logged in Successfully for Linga Enterprise ");
				}
				else
				{
					test.log(LogStatus.FAIL, "User Logged in Failed for Linga Enterprise ");
				}
/*				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(20000);
				if(driver.findElement(By.xpath("//span[.='Live Updates']")).isDisplayed())
				{
					System.out.println("TEST");
				}
				else{*/
				
				Thread.sleep(10000);
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
				driver.findElement(By.name("txtusername")).sendKeys("admin@austinfiregrill.com");
				//Clear the password from the password text box
				driver.findElement(By.name("txtpassword")).clear();
				//Enter the password
				driver.findElement(By.name("txtpassword")).sendKeys("linga123");
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
				}
			}

		}

	@Test(priority=4)
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
		//driver.close();
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
	public void apply_Not_Applicable() throws Exception
	{
		
		
		File src = new File(Utility.getProperty("Excel_Sheet_Path"));
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
	
		Thread.sleep(3000);
		//Enter the cashierOut Url
		driver.get(Utility.getProperty("baseURL")+"5c41e5dd90d88f0001d47213/users");

		Thread.sleep(3000);
		
		
		//Click the Pagination option as 20
		driver.findElement(By.xpath("//span[@ng-bind='count' and .='20']")).click();
		
		
		List<WebElement> option = driver.findElements(By.xpath("//span[@ng-bind='page.number']"));
		option.size();
		int k = 1;
		
		for(int i = 2; i <= option.size()+1; i++)
		{
				driver.findElement(By.xpath("//ul/li["+i+"]/a/span[@ng-bind='page.number']")).click();				
				List<WebElement> row = driver.findElements(By.xpath("//table[@class='table table-hover table-nomargin table-bordered ng-table-responsive ng-scope ng-table']/tbody/tr"));
				row.size();
				for(int j = 1;j <= row.size(); j++)
				{
					sheet1.getRow(k).createCell(1).setCellValue(driver.findElement(By.xpath("//table[@class='table table-hover table-nomargin table-bordered ng-table-responsive ng-scope ng-table']/tbody/tr["+j+"]/td[2]")).getText());
					sheet1.getRow(k).createCell(2).setCellValue(driver.findElement(By.xpath("//table[@class='table table-hover table-nomargin table-bordered ng-table-responsive ng-scope ng-table']/tbody/tr["+j+"]/td[3]")).getText());
					String str1 = sheet1.getRow(k).getCell(1).getStringCellValue();
					String str2 = sheet1.getRow(k).getCell(2).getStringCellValue();
					String str3 = str1 +" "+ str2;
					sheet1.getRow(k).createCell(3).setCellValue(str3);
					k++;
				}	
				
		}
		

		Thread.sleep(3000);				
		FileOutputStream fout = new FileOutputStream(src);
		
		wb.write(fout);
		
		wb.close();
	}

	@Test(priority=3,enabled=true)
	public void getTheValue_Of_Cashier_Report() throws Exception
	{
		File src = new File(Utility.getProperty("Excel_Sheet_Path"));
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		Thread.sleep(3000);
		//Enter the cashierOut Url
		driver.get(Utility.getProperty("baseURL")+"5c41e5dd90d88f0001d47213/report/cashierOut");

		Thread.sleep(5000);
		//Click the Employee option
		driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
		//Enter the required employee
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
		
		Thread.sleep(2000);
		//Click the Run Button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		
		//Get the Net_Sales Amount
		String netSales = driver.findElement(By.xpath("//div[contains(.,'Net Sales')]/span")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		double netsale = Double.parseDouble(netSales);
		
		//Get the values of Tax
		String TaxnetSales = driver.findElement(By.xpath("//b[.='TAXES']/../../../div[3]/div[3]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		double tnetsale = Double.parseDouble(TaxnetSales);
		
		if(netsale == tnetsale)
		{
			System.out.println("No Diff between Netsales and Tax Netsales");
		}
		else
		{
			double didd = netsale - tnetsale;
			System.out.println("Netsale difference is : "+didd);
			
			List<WebElement> option = driver.findElements(By.xpath("//form[@name='saleReport']/div[1]/div/select/option"));
			option.size();
			//System.out.println(option.size());
			
			//List<String> all = new ArrayList<>();
			int rowCount = sheet1.getLastRowNum();
			//System.out.println("Rowcount : "+rowCount);
			for(int i = 1; i < rowCount;i++)
			{
				//Click the Employee option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required employee
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(sheet1.getRow(i).getCell(3).getStringCellValue());
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);

				
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(2000);
				
				//Get the Net_Sales Amount
				String netSales1 = driver.findElement(By.xpath("//div[contains(.,'Net Sales')]/span")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
				double netsale1 = Double.parseDouble(netSales1);

				if(netsale1 == 0)
				{}
				else
				{
					//Get the values of Tax
					String TaxnetSales1 = driver.findElement(By.xpath("//b[.='TAXES']/../../../div[3]/div[3]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
					double tnetsale1 = Double.parseDouble(TaxnetSales1);
					
					if(netsale1 == tnetsale1)
					{
						//System.out.println("No Diff between Netsales and Tax Netsales for "+ sheet1.getRow(i).getCell(3).getStringCellValue());
					}
					else
					{
						double diff = netsale1 - tnetsale1;
						try
						{
							System.out.println(driver.findElement(By.xpath("//label[.='Employee:']/..")).getText()+" - "+diff);
							//System.out.println("Different Amount is : "+diff);
							
						}
						catch(Exception e)
						{
							
						}
						
					}
				}
			}
		}
		wb.close();
	}

	@Test(priority=6)
	public void login_Ridgway_Bar_And_Grill() throws Exception
	{
		if(Utility.getProperty("Product").equalsIgnoreCase("UPOS"))
		{
/*			Thread.sleep(2000);
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
			driver.get(Utility.getProperty("appURL"));*/
			//Clear the text from the user name text box
			driver.findElement(By.name("emailId")).clear();
			//Enter the user name
			driver.findElement(By.name("emailId")).sendKeys("support@ridgway.com");
			Thread.sleep(1000);
			//Clear the password from the password text box
			driver.findElement(By.name("password")).clear();
			//Enter the password
			driver.findElement(By.name("password")).sendKeys("linga123");
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
			Thread.sleep(10000);
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
			if(Utility.getProperty("Substore_OR_Multistore").equalsIgnoreCase("Multi"))
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
				driver.findElement(By.name("txtusername")).sendKeys("support@ridgway.com");
				//Clear the password from the password text box
				driver.findElement(By.name("txtpassword")).clear();
				//Enter the password
				driver.findElement(By.name("txtpassword")).sendKeys("linga123");
				Thread.sleep(4000);

				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
			
				//Click the login button
				driver.findElement(By.name("submitlogin")).click();Thread.sleep(8000);
				//Check if we logged in or not
				if(driver.findElement(By.xpath("//div[@id='navigation']/ul[1]/li/a")).getText().equalsIgnoreCase("My Stores"))
				{
					test.log(LogStatus.PASS, "User Logged in Successfully for Linga Enterprise ");
				}
				else
				{
					test.log(LogStatus.FAIL, "User Logged in Failed for Linga Enterprise ");
				}
/*				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(20000);
				if(driver.findElement(By.xpath("//span[.='Live Updates']")).isDisplayed())
				{
					System.out.println("TEST");
				}
				else{*/
				
				Thread.sleep(10000);
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
				driver.findElement(By.name("txtusername")).sendKeys("support@ridgway.com");
				//Clear the password from the password text box
				driver.findElement(By.name("txtpassword")).clear();
				//Enter the password
				driver.findElement(By.name("txtpassword")).sendKeys("linga123");
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
				}
			}

		}

	@Test(priority=10)
	public void logout_Ridgway_Bar_And_Grill() throws Exception
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

	@Test(priority=8)
	public void apply_Not_Applicable_Ridgway_Bar_And_Grill() throws Exception
	{
		
		
		File src = new File(Utility.getProperty("Excel_Sheet_Path"));
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 = wb.getSheetAt(1);
			
		Thread.sleep(3000);
		//Enter the cashierOut Url
		driver.get(Utility.getProperty("baseURL")+"5b97c61f0641790001b87ce6/users");

		Thread.sleep(3000);
		
		
		//Click the Pagination option as 20
		driver.findElement(By.xpath("//span[@ng-bind='count' and .='20']")).click();
		
		
		List<WebElement> option = driver.findElements(By.xpath("//span[@ng-bind='page.number']"));
		option.size();
		int k = 1;
		
		for(int i = 2; i <= option.size()+1; i++)
		{
				driver.findElement(By.xpath("//ul/li["+i+"]/a/span[@ng-bind='page.number']")).click();				
				List<WebElement> row = driver.findElements(By.xpath("//table[@class='table table-hover table-nomargin table-bordered ng-table-responsive ng-scope ng-table']/tbody/tr"));
				row.size();
				for(int j = 1;j <= row.size(); j++)
				{
					sheet1.getRow(k).createCell(1).setCellValue(driver.findElement(By.xpath("//table[@class='table table-hover table-nomargin table-bordered ng-table-responsive ng-scope ng-table']/tbody/tr["+j+"]/td[2]")).getText());
					sheet1.getRow(k).createCell(2).setCellValue(driver.findElement(By.xpath("//table[@class='table table-hover table-nomargin table-bordered ng-table-responsive ng-scope ng-table']/tbody/tr["+j+"]/td[3]")).getText());
					String str1 = sheet1.getRow(k).getCell(1).getStringCellValue();
					String str2 = sheet1.getRow(k).getCell(2).getStringCellValue();
					String str3 = str1 +" "+ str2;
					sheet1.getRow(k).createCell(3).setCellValue(str3);
					k++;
				}	
				
		}
		

		Thread.sleep(3000);				
		FileOutputStream fout = new FileOutputStream(src);
		
		wb.write(fout);
		
		wb.close();
	}

	@Test(priority=9,enabled=true)
	public void getTheValue_Of_Cashier_Report_Ridgway_Bar_And_Grill() throws Exception
	{
		File src = new File(Utility.getProperty("Excel_Sheet_Path"));
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 = wb.getSheetAt(1);
		
		Thread.sleep(3000);
		//Enter the cashierOut Url
		driver.get(Utility.getProperty("baseURL")+"5b97c61f0641790001b87ce6/report/cashierOut");

		Thread.sleep(5000);
		//Click the Employee option
		driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
		//Enter the required employee
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
		
		Thread.sleep(2000);
		//Click the Run Button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		
		//Get the Net_Sales Amount
		String netSales = driver.findElement(By.xpath("//div[contains(.,'Net Sales')]/span")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		double netsale = Double.parseDouble(netSales);
		
		//Get the values of Tax
		String TaxnetSales = driver.findElement(By.xpath("//b[.='TAXES']/../../../div[3]/div[3]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		double tnetsale = Double.parseDouble(TaxnetSales);
		
		if(netsale == tnetsale)
		{
			System.out.println("No Diff between Netsales and Tax Netsales for Ridgway Bar And Grill");
		}
		else
		{
			double didd = netsale - tnetsale;
			System.out.println("Netsale difference is : "+didd);
			
			List<WebElement> option = driver.findElements(By.xpath("//form[@name='saleReport']/div[1]/div/select/option"));
			option.size();
			//System.out.println(option.size());
			
			//List<String> all = new ArrayList<>();
			int rowCount = sheet1.getLastRowNum();
			//System.out.println("Rowcount : "+rowCount);
			for(int i = 1; i < rowCount;i++)
			{
				//Click the Employee option
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/a")).click();
				//Enter the required employee
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(sheet1.getRow(i).getCell(3).getStringCellValue());
				//Press the Enter Key
				driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);

				
				//Click the Run Button
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				Thread.sleep(2000);
				
				//Get the Net_Sales Amount
				String netSales1 = driver.findElement(By.xpath("//div[contains(.,'Net Sales')]/span")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
				double netsale1 = Double.parseDouble(netSales1);

				if(netsale1 == 0)
				{}
				else
				{
					//Get the values of Tax
					String TaxnetSales1 = driver.findElement(By.xpath("//b[.='TAXES']/../../../div[3]/div[3]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
					double tnetsale1 = Double.parseDouble(TaxnetSales1);
					
					if(netsale1 == tnetsale1)
					{
						//System.out.println("No Diff between Netsales and Tax Netsales for "+ sheet1.getRow(i).getCell(3).getStringCellValue());
					}
					else
					{
						double diff = netsale1 - tnetsale1;
						try
						{
							System.out.println(driver.findElement(By.xpath("//label[.='Employee:']/..")).getText()+" - "+diff);
							
							//System.out.println(driver.findElement(By.xpath("//label[.='Employee:']/..")).getText()+" - "+diff);
							//System.out.println("Different Amount is : "+diff);
							
						}
						catch(Exception e)
						{
							
						}
						
					}
				}
			}
		}
		wb.close();
	}

}