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
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import epicList_Chrome.Utility;
import newReadExcelFile_New.ExcelDataConfig;

public class Verify_Refund_Report {


	public WebDriver driver;

		ExtentReports rep = ExtentManager.getInstance();
		ExtentTest test = rep.startTest("Verify_Refund_Report");
		
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
			
			SendMail.snedMailWithAttachment();
		}

		@Test(priority=1)
		public void login() throws Exception
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
			if(Utility.getProperty("Product").equalsIgnoreCase("UPOS"))
			{
				Browser a = new Browser();
				a.UPOS_login(driver, test);
			}
			else 			
			{
				Browser a = new Browser();
				a.Linga_login(driver, test);
			}	
		}
			
		@Test(priority=500)
		public void logout() throws Exception
		{		Browser a = new Browser();
		a.Logout(driver, test);}
	
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
			Refund_Report_Method_Openpage(driver);
			Refund_Report_Method_verify_By_Payment_Type(driver);
			Refund_Report_Method_verify_By_Payment_Name(driver);
			Thread.sleep(1500);
		}

		@Test(enabled=false,priority=6)
		public void Refund_Report_Method_Openpage(WebDriver driver) throws Exception
		{
            File src = new File(Utility.getProperty("Excel_Sheet_Path_For_Xpath"));
			
			FileInputStream fis = new FileInputStream(src);
			
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			XSSFSheet sheet1 = wb.getSheetAt(1);sheet1.getLastRowNum();
			
			ExcelDataConfig excel = new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_For_Xpath"));
			/*	//Click the Reports option
			driver.findElement(By.xpath("//span[.='Reports']")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// Create instance of Java script executor
			JavascriptExecutor je = (JavascriptExecutor) driver;
			//Identify the WebElement which will appear after scrolling down
			WebElement element = driver.findElement(By.xpath("//span[.='Refund']"));
			//Scroll the page till the Daily Tender option present
			je.executeScript("arguments[0].scrollIntoView(true);",element); 
			//Click the Refund Option		
			driver.findElement(By.xpath("//span[.='Refund']")).click();  */
			
			Thread.sleep(3000);
			//Enter the Users URL
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"refundReport");
			
			Thread.sleep(5000);
			//Check Daily Tender page opened or not
			if(driver.findElement(By.xpath(excel.getData(1, 1092, 1))).getText().equalsIgnoreCase("Refund"))
			{
				test.log(LogStatus.PASS,"Refund Report page loaded Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL,"Refund Report page loaded Failed");
			}
			
			Thread.sleep(3000);wb.close();
			
		}

		@Test(enabled=false,priority=7)
		public void Refund_Report_Method_verify_By_Payment_Type(WebDriver driver) throws Exception
		{
			File src = new File(Utility.getProperty("Excel_Sheet_Path_For_Xpath"));
			
			FileInputStream fis = new FileInputStream(src);
			
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			XSSFSheet sheet1 = wb.getSheetAt(1);sheet1.getLastRowNum();
			
			ExcelDataConfig excel = new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_For_Xpath"));
			Thread.sleep(5000);
			//Select the Employee option
			driver.findElement(By.xpath(excel.getData(1, 1093, 1))).click();
			//Enter the required Employee
			driver.findElement(By.xpath(excel.getData(1, 1094, 1))).sendKeys("All");
			//Press the Enter key
			driver.findElement(By.xpath(excel.getData(1, 1094, 1))).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			
			Select payment_Option = new Select(driver.findElement(By.xpath(excel.getData(1, 1095, 1))));
			payment_Option.selectByVisibleText("By Payment Type");
			
			Thread.sleep(5000);
			//Select the Payment Type option
			driver.findElement(By.xpath(excel.getData(1, 1096, 1))).click();
			//Enter the required Payment Type
			driver.findElement(By.xpath(excel.getData(1, 1097, 1))).sendKeys("All");
			//Press the Enter key
			driver.findElement(By.xpath(excel.getData(1, 1097, 1))).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			
			Thread.sleep(5000);
			//Select the Time Period option
			driver.findElement(By.xpath(excel.getData(1, 1098, 1))).click();
			//Enter the required Period of time for Specific date
			driver.findElement(By.xpath(excel.getData(1, 1099, 1))).sendKeys("Date Range");
			//Press the Enter key
			driver.findElement(By.xpath(excel.getData(1, 1099, 1))).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			
			//Clear the Date Field
			driver.findElement(By.xpath(excel.getData(1, 1100, 1))).clear();
			//Enter the specific date
			driver.findElement(By.xpath(excel.getData(1, 1100, 1))).sendKeys(Utility.getReportProperty("Date_Range_From"));
			
			   //Clear the Date Field
			driver.findElement(By.xpath(excel.getData(1, 1101, 1))).clear();
			//Enter the specific date
			driver.findElement(By.xpath(excel.getData(1, 1101, 1))).sendKeys(Utility.getReportProperty("Date_Range_To"));
			
			//Click the Run
			driver.findElement(By.cssSelector(excel.getData(1, 974, 4))).click();
			Thread.sleep(2000);
			
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			try
			{
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath(excel.getData(1,704, 1))).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Refund Report(By Payment Type) is not available for Specific Date");
				}
			}
			catch(Exception ds)
			{
				
				test.log(LogStatus.PASS, "Refund Report(By Payment Type) is available for Specific Date");
				
				List<WebElement> rows = driver.findElements(By.xpath(excel.getData(1,1070, 1)));
				
			
					String amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[7]")).getText();
				
					System.out.println("Total Amount(By Payment Type) is : "+amount);
			
					test.log(LogStatus.INFO, "Total Amount(By Payment Type) is : "+amount);
				
			}
			Thread.sleep(2000);wb.close();
			
		}
		
		@Test(enabled=false,priority=8)
		public void Refund_Report_Method_verify_By_Payment_Name(WebDriver driver) throws Exception
		{

			File src = new File(Utility.getProperty("Excel_Sheet_Path_For_Xpath"));
			
			FileInputStream fis = new FileInputStream(src);
			
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			XSSFSheet sheet1 = wb.getSheetAt(1);sheet1.getLastRowNum();
			
			ExcelDataConfig excel = new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_For_Xpath"));
			Thread.sleep(5000);
			//Select the Employee option
			driver.findElement(By.xpath(excel.getData(1, 1093, 1))).click();
			//Enter the required Employee
			driver.findElement(By.xpath(excel.getData(1, 1094, 1))).sendKeys("All");
			//Press the Enter key
			driver.findElement(By.xpath(excel.getData(1, 1094, 1))).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			
			Select payment_Option = new Select(driver.findElement(By.xpath(excel.getData(1, 1095, 1))));
			payment_Option.selectByVisibleText("By Payment Name");
			
			Thread.sleep(5000);
			//Select the Payment Type option
			driver.findElement(By.xpath(excel.getData(1, 1096, 1))).click();
			//Enter the required Payment Type
			driver.findElement(By.xpath(excel.getData(1, 1097, 1))).sendKeys("All");
			//Press the Enter key
			driver.findElement(By.xpath(excel.getData(1, 1097, 1))).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			
			Thread.sleep(5000);
			//Select the Time Period option
			driver.findElement(By.xpath(excel.getData(1, 1098, 1))).click();
			//Enter the required Period of time for Specific date
			driver.findElement(By.xpath(excel.getData(1, 1099, 1))).sendKeys("Date Range");
			//Press the Enter key
			driver.findElement(By.xpath(excel.getData(1, 1099, 1))).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			
			//Clear the Date Field
			driver.findElement(By.xpath(excel.getData(1, 1100, 1))).clear();
			//Enter the specific date
			driver.findElement(By.xpath(excel.getData(1, 1100, 1))).sendKeys(Utility.getReportProperty("Date_Range_From"));
			
			   //Clear the Date Field
			driver.findElement(By.xpath(excel.getData(1, 1101, 1))).clear();
			//Enter the specific date
			driver.findElement(By.xpath(excel.getData(1, 1101, 1))).sendKeys(Utility.getReportProperty("Date_Range_To"));
			
			//Click the Run
			driver.findElement(By.cssSelector(excel.getData(1, 974, 4))).click();
			Thread.sleep(2000);
			
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			try
			{
				//Check weather the report is available for the selected time period
				if(driver.findElement(By.xpath(excel.getData(1, 704, 1))).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Refund Report(By Payment Name) is not available for Specific Date");
				}
			}
			catch(Exception fd)
			{
				
				test.log(LogStatus.PASS, "Refund Report(By Payment Name) is available for Specific Date");
				
				List<WebElement> rows = driver.findElements(By.xpath(excel.getData(1,1070, 1)));
				
			
					String amount = driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div/div/div[5]/table/tbody/tr["+rows.size()+"]/td[7]")).getText();
				
					System.out.println("Total Amount(By Payment Name) is : "+amount);
			
					test.log(LogStatus.INFO, "Total Amount(By Payment Name) is : "+amount);
			}
			Thread.sleep(2000);wb.close();
		}
}
