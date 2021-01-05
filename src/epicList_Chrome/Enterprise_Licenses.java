package epicList_Chrome;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import newReadExcelFile_New.ExcelDataConfig;

public class Enterprise_Licenses 
{
	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Enterprise_Licenses");

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
			Licenses_open_page(driver);
			Reset_Licenses(driver);
			Verify_UnLinked_Licenses(driver);
			Thread.sleep(1500);
		}

		@Test(enabled=false,priority=15)
		public void Licenses_open_page(WebDriver driver) throws Exception
		{
			File src = new File(Utility.getProperty("Excel_Sheet_Path_For_Xpath"));
			
			FileInputStream fis = new FileInputStream(src);
			
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			XSSFSheet sheet1 = wb.getSheetAt(1);sheet1.getLastRowNum();
			
			ExcelDataConfig excel = new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_For_Xpath"));

			//Enter the URl
			Thread.sleep(3000);
			driver.get(Utility.getProperty("Enterprise_Base_URL")+"licenses");
			
			Thread.sleep(5000);
			//Check whether the Licenses page Opened or not
			if(driver.findElement(By.xpath(excel.getData(3, 2124, 1))).getText().equalsIgnoreCase("Licenses"))
			{
				test.log(LogStatus.PASS, "Licenses page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Licenses page loaded Failed");
			}
			wb.close();
			Thread.sleep(3000);
		}
		
		
	@Test(enabled=false,priority=16)
	public void Reset_Licenses(WebDriver driver) throws Exception
	{
		 File src = new File(Utility.getProperty("Excel_Sheet_Path_For_Xpath"));
			
			FileInputStream fis = new FileInputStream(src);
			
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			XSSFSheet sheet1 = wb.getSheetAt(1);sheet1.getLastRowNum();
			
			ExcelDataConfig excel = new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_For_Xpath"));

		Thread.sleep(5000);
		
		//Refresh the Licenses page
		driver.findElement(By.xpath(excel.getData(3, 2125, 1))).click();
		
		Thread.sleep(4000);
		//Clear the Search box
		driver.findElement(By.xpath(excel.getData(3, 40, 1))).clear();
		Thread.sleep(1000);
		//Enter the Node Id
		driver.findElement(By.xpath(excel.getData(3, 40, 1))).sendKeys("A002");
		
		Thread.sleep(4000);
		//Click the Unlink button to Searched Node ID
		driver.findElement(By.xpath(excel.getData(3, 544, 1))).click();
		
		Thread.sleep(2000);
		//Click Yes button
		driver.findElement(By.linkText("Yes")).click();
		
		Thread.sleep(4000);
		//Check whether the Licenses Unlinked/Reset or not
		if(driver.findElement(By.xpath(excel.getData(3, 39, 1))).getText().equalsIgnoreCase("License unLinked from the device successfully"))
		{
			test.log(LogStatus.PASS, "Licenses Reset/Unlinked Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Licenses Reset/Unlinked Failed");
		}
	
		wb.close();
		Thread.sleep(3000);
	}

	@Test(enabled=false,priority=17)
	public void Verify_UnLinked_Licenses(WebDriver driver) throws Exception
	{
		 File src = new File(Utility.getProperty("Excel_Sheet_Path_For_Xpath"));
			
			FileInputStream fis = new FileInputStream(src);
			
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			XSSFSheet sheet1 = wb.getSheetAt(1);sheet1.getLastRowNum();
			
			ExcelDataConfig excel = new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_For_Xpath"));

		Thread.sleep(5000);
		//Clear the Search box
		driver.findElement(By.xpath(excel.getData(3, 40, 1))).clear();
		Thread.sleep(1000);
		//Enter the Node ID
		driver.findElement(By.xpath(excel.getData(3, 40, 1))).sendKeys("A002");
		
		Thread.sleep(4000);
		//Check whether the License UnLinked/Reseted or not
		if(driver.findElement(By.xpath(excel.getData(3, 2126, 1))).isDisplayed())
		{
			test.log(LogStatus.PASS, "License Unlinked from the Device Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "License Unlinked from the Device Failed");
		}
		wb.close();
		Thread.sleep(5000);
	}
}
