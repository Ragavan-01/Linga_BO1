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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class WirteReports{
	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Report Verification");
	
	@AfterClass
	public void flushTest() throws Exception
	{
		Thread.sleep(2000);
		rep.endTest(test);
		rep.flush();
		
		SendMail.snedMailWithExcelAttachment();
	}
	
	@Test(priority=1,enabled=true)
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
		//Launch the URL
		driver.get(Utility.getProperty("appURL"));
		//Clear the text from the user name text box
		driver.findElement(By.name("txtusername")).clear();
		//Enter the user name
		driver.findElement(By.name("txtusername")).sendKeys("admin@patel.com");
		//Clear the password from the password text box
		driver.findElement(By.name("txtpassword")).clear();
		//Enter the password
		driver.findElement(By.name("txtpassword")).sendKeys("linga123");
		Thread.sleep(3000);

		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
		//Click the login button
		driver.findElement(By.name("submitlogin")).click();Thread.sleep(6000);//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
/*				//Check if we logged in or not
		if(driver.findElement(By.xpath("//span[.='Live Updates']")).getText().equalsIgnoreCase("Live Updates"))
		{
			test.log(LogStatus.PASS, "User Logged in Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "User Logged in Failed");
		}*/
		Thread.sleep(5000);
		//Click the Burn By Rocky Patel
		driver.findElement(By.xpath("//a/h5[contains(.,'Burn By Rocky Patel')]")).click();

}
		
	@Test(priority=500,enabled=true)
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

	@Test(priority=2, enabled=true)
	public void apply_Not_Applicable() throws Exception
	{
		
		
		File src = new File(Utility.getProperty("Excel_Sheet_Path"));
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 = wb.getSheetAt(0);
		sheet1.getRow(1).createCell(0).setCellValue(Utility.getReportProperty("Date_Range_From"));
		for(int i = 1; i <= 30; i++)
		{
			for(int j = 2; j <= 14; j++)
			{
				sheet1.getRow(j).createCell(i).setCellValue("-");
			}
			
		}
		Thread.sleep(3000);				
		FileOutputStream fout = new FileOutputStream(src);
		
		wb.write(fout);
		
		wb.close();
	}

	@Test(priority=3,enabled=true)
	public void getTheValue_Of_Sale_Recap_Report() throws Exception
	{
		File src = new File(Utility.getProperty("Excel_Sheet_Path"));
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		Thread.sleep(8000);
		//Enter the SaleRecap Url
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/saleRecap");

		Thread.sleep(5000);
		//Click the Select Recap Type option
		driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/a")).click();
		//Enter the required department
		driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/input")).sendKeys("Time period");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='saleReport']/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(3000);
		//Click the Employee option
		driver.findElement(By.xpath("//form[@name='saleReport']/div[2]/div/div/a")).click();
		//Enter the required employee
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
		
		Thread.sleep(2000);
		//Click the Run Button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		
		//Get the Net_Sales Amount
		String netSales = driver.findElement(By.xpath("//div[contains(.,'Net Sales')]/span")).getText();
		//double netSaleAmount = Double.parseDouble(netSales);
		sheet1.getRow(2).createCell(1).setCellValue(netSales);
		
		//Get the count of Tax
		List<WebElement> taxRow = driver.findElements(By.xpath("//b[.='TAXES']/../../../div"));
		//int numTax = taxRow.size() - 3;//Here 3 for 3 rows of headings
		 
		int j = 2;
		//Get all the details of rows
		for(int i = 3; i < taxRow.size(); i++)
		{
			
			for(int k = 1; k <= 4;k++)
			{
				//Get the values of Tax
				String name = driver.findElement(By.xpath("//b[.='TAXES']/../../../div["+i+"]/div["+k+"]")).getText();
				sheet1.getRow(2).createCell(j).setCellValue(name);

				j++;
			}
			
		}
				
		//Get the Total Tax Amount
		String total_tax = driver.findElement(By.xpath("//b[.='TAXES']/../../../div/div[contains(.,'TOTAL')]/../div[4]")).getText();
		//double netSaleAmount = Double.parseDouble(netSales);
		sheet1.getRow(2).createCell(14).setCellValue(total_tax);
		int l = 15;
		//Get all the details of rows
		for(int i = 3; i < taxRow.size(); i++)
		{
			
			//Get the Value of Tax Exempt
			String name = driver.findElement(By.xpath("//b[.='TAXES']/../../../div["+i+"]/div[5]")).getText();
			sheet1.getRow(2).createCell(l).setCellValue(name);
			l++;
			 
		}
		
		//Get the Total Tax Exempt Amount
		String total_tax_exempt = driver.findElement(By.xpath("//b[.='TAXES']/../../../div/div[contains(.,'TOTAL')]/../div[5]")).getText();
		//double netSaleAmount = Double.parseDouble(netSales);
		sheet1.getRow(2).createCell(18).setCellValue(total_tax_exempt);
		
		//Get the CC Sales amount
		String cc_sales_amount = driver.findElement(By.xpath("//b[.='CREDIT CARD']/../../../div/div[contains(.,'TOTAL')]/../div[3]")).getText();
		sheet1.getRow(2).createCell(19).setCellValue(cc_sales_amount);
		
		//Get the CC Tips amount
		String cc_tips_amount = driver.findElement(By.xpath("//b[.='CREDIT CARD']/../../../div/div[contains(.,'TOTAL')]/../div[4]")).getText();
		sheet1.getRow(2).createCell(20).setCellValue(cc_tips_amount);
		
		try {
			//Get the Gratuity amount
			String Gratuity = driver.findElement(By.xpath("//b[.='TIP / GRATUITY ']/../../..//div[contains(.,'Gratuity')]/span")).getText();
			sheet1.getRow(2).createCell(21).setCellValue(Gratuity);
		} catch (Exception e) {}
		
		try {
			//Get the Employee Tip amount
			String employee_Tip = driver.findElement(By.xpath("//b[.='TIP / GRATUITY ']/../../..//div[contains(.,'Employee Tip')]/span")).getText();
			sheet1.getRow(2).createCell(22).setCellValue(employee_Tip);
		} catch (Exception e) {}
		
		try {
			//Get the House Account amount
			String house_Account = driver.findElement(By.xpath("//b[.='TIP / GRATUITY ']/../../..//div[contains(.,'House Account')]/span")).getText();
			sheet1.getRow(2).createCell(23).setCellValue(house_Account);
		} catch (Exception e) {}
		
		try {
			//Get the GiveX Tip amount
			String GiveXTip = driver.findElement(By.xpath("//b[.='TIP / GRATUITY ']/../../..//div[contains(.,'GiveX')]/span")).getText();
			sheet1.getRow(2).createCell(24).setCellValue(GiveXTip);
		} catch (Exception e) {}
		
		try {
			//Get the Gift Card Tip amount
			String GiftCardTipAmount = driver.findElement(By.xpath("//b[.='TIP / GRATUITY ']/../../..//div[contains(.,'Gift Card')]/span")).getText();
			sheet1.getRow(2).createCell(25).setCellValue(GiftCardTipAmount);
		} catch (Exception e) {}
		
		try {
			//Get the Tip Charge amount
			String tip_Charge = driver.findElement(By.xpath("//b[.='TIP / GRATUITY ']/../../..//div[contains(.,'Tip Charge')]/span")).getText();
			sheet1.getRow(2).createCell(26).setCellValue(tip_Charge);
		} catch (Exception e) {}
		
		try {
			//Get the Driver Tip amount
			String driver_Tip = driver.findElement(By.xpath("//b[.='TIP / GRATUITY ']/../../..//div[contains(.,'Driver Tip')]/span")).getText();
			sheet1.getRow(2).createCell(27).setCellValue(driver_Tip);
		} catch (Exception e) {}
		
		try{
			//Get the Discount value
			String disTotal = driver.findElement(By.xpath("//b[contains(.,'DISCOUNT')]/../../../div[contains(.,'TOTAL')]/span")).getText();
			sheet1.getRow(2).createCell(28).setCellValue(disTotal);
		}catch(Exception e){}
		
		try{
			//Get the Discount value
			String disTotal = driver.findElement(By.xpath("//b[contains(.,'DEPARTMENT SUMMARY')]/../../../div[contains(.,'TOTAL')]/span")).getText();
			sheet1.getRow(2).createCell(29).setCellValue(disTotal);
		}catch(Exception e){}
		
		try{
			//Get the Discount value
			String disTotal = driver.findElement(By.xpath("//b[contains(.,'CATEGORY SUMMARY')]/../../../div[contains(.,'TOTAL')]/span")).getText();
			sheet1.getRow(2).createCell(30).setCellValue(disTotal);
		}catch(Exception e){}
		
		FileOutputStream fout = new FileOutputStream(src);
		
		wb.write(fout);
		
		wb.close();
	}

	@Test(priority=4,enabled=true)
	public void getTheValue_Of_Department_Sale_Report() throws Exception
	{
		
		
		File src = new File(Utility.getProperty("Excel_Sheet_Path"));
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		Thread.sleep(3000);
		//Enter the department Sale Url
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/departmentSale");

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
		Thread.sleep(5000);
		if(driver.findElement(By.xpath("//h3[contains(.,'No')]")).isDisplayed())
		{
			
		}

		else
		{
			
	        //No.of rows
	        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
			
			//Get the Sale Amount
			String sale_Amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
			//double netSaleAmount = Double.parseDouble(netSales);
			sheet1.getRow(3).createCell(1).setCellValue(sale_Amount);
			
			//Get the Tax Amount
			String tax_Amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
			//double netSaleAmount = Double.parseDouble(netSales);
			sheet1.getRow(3).createCell(14).setCellValue(tax_Amount);
			
			//Get the Discount Amount
			String disc_Total = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();			
			sheet1.getRow(3).createCell(28).setCellValue(disc_Total);
		}
				
		FileOutputStream fout = new FileOutputStream(src);
		
		wb.write(fout);
		
		wb.close();
	}

	@Test(priority=5,enabled=true)
	public void getTheValue_Of_Category_Sale_Report() throws Exception
	{
		
		
		File src = new File(Utility.getProperty("Excel_Sheet_Path"));
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		Thread.sleep(3000);
		//Enter the category Sale Url
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/categorySale");

		Thread.sleep(5000);
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

		
		Thread.sleep(5000);
		if(driver.findElement(By.xpath("//h3[contains(.,'No')]")).isDisplayed())
		{
			
		}

		else
		{
	        //No.of rows
	        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
			
			//Get the Sale Amount
			String sale_Amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
			//double netSaleAmount = Double.parseDouble(netSales);
			sheet1.getRow(4).createCell(1).setCellValue(sale_Amount);
			
			//Get the Tax Amount
			String tax_Amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
			//double netSaleAmount = Double.parseDouble(netSales);
			sheet1.getRow(4).createCell(14).setCellValue(tax_Amount);
			
			//Get the Discount Amount
			String disc_Amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
			sheet1.getRow(4).createCell(28).setCellValue(disc_Amount);
		}
		
		FileOutputStream fout = new FileOutputStream(src);
		
		wb.write(fout);
		
		wb.close();
	}

	@Test(priority=6,enabled=true)
	public void getTheValue_Of_Sub_Category_Sale_Report() throws Exception
	{
		
		
		File src = new File(Utility.getProperty("Excel_Sheet_Path"));
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		Thread.sleep(3000);
		//Enter the sub category Sale Url
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/subCategorySale");

		Thread.sleep(5000);
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

		Thread.sleep(5000);
		if(driver.findElement(By.xpath("//h3[contains(.,'No')]")).isDisplayed())
		{
			
		}

		else
		{
	        //No.of rows
	        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
			
			//Get the Sale Amount
			String sale_Amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
			//double netSaleAmount = Double.parseDouble(netSales);
			sheet1.getRow(5).createCell(1).setCellValue(sale_Amount);
			
			//Get the Tax Amount
			String tax_Amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
			//double netSaleAmount = Double.parseDouble(netSales);
			sheet1.getRow(5).createCell(14).setCellValue(tax_Amount);
			
			//Get the Discount Amount
			String disc_Amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
			sheet1.getRow(5).createCell(28).setCellValue(disc_Amount);
		}
			
		FileOutputStream fout = new FileOutputStream(src);
		
		wb.write(fout);
		
		wb.close();
	}

	@Test(priority=7,enabled=true)
	public void getTheValue_Of_Menu_Item_Sale_Report() throws Exception
	{
		
		
		File src = new File(Utility.getProperty("Excel_Sheet_Path"));
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		Thread.sleep(3000);
		//Enter the menu item Sale report Url
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/menuItemSale");

		Thread.sleep(5000);
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

		Thread.sleep(5000);
		if(driver.findElement(By.xpath("//h3[contains(.,'No')]")).isDisplayed())
		{
			
		}

		else
		{
	        //No.of rows
	        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
			
			//Get the Sale Amount
			String sale_Amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
			//double netSaleAmount = Double.parseDouble(netSales);
			sheet1.getRow(6).createCell(1).setCellValue(sale_Amount);
			
			//Get the Tax Amount
			String tax_Amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
			//double netSaleAmount = Double.parseDouble(netSales);
			sheet1.getRow(6).createCell(14).setCellValue(tax_Amount);
			
			//Get the Discount Amount
			String disc_Amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
			sheet1.getRow(6).createCell(28).setCellValue(disc_Amount);
		}
		
		FileOutputStream fout = new FileOutputStream(src);
		
		wb.write(fout);
		
		wb.close();
	}

	@Test(priority=8,enabled=true)
	public void getTheValue_Of_Modifier_Sale_Report() throws Exception
	{
		
		
		File src = new File(Utility.getProperty("Excel_Sheet_Path"));
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		Thread.sleep(3000);
		//Enter the modifier Sale report Url
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/modifierSale");

		Thread.sleep(5000);
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

		Thread.sleep(5000);
		if(driver.findElement(By.xpath("//h3[contains(.,'No')]")).isDisplayed())
		{
			
		}

		else
		{
	        //No.of rows
	        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
			
			//Get the Sale Amount
			String sale_Amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]")).getText();
			//double netSaleAmount = Double.parseDouble(netSales);
			sheet1.getRow(7).createCell(1).setCellValue(sale_Amount);
			
			//Get the Tax Amount
			String tax_Amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText();
			//double netSaleAmount = Double.parseDouble(netSales);
			sheet1.getRow(7).createCell(14).setCellValue(tax_Amount);
			
		}
		
		FileOutputStream fout = new FileOutputStream(src);
		
		wb.write(fout);
		
		wb.close();
	}

	@Test(priority=9,enabled=true)
	public void getTheValue_Of_Hourly_Sale_Report() throws Exception
	{
		
		
		File src = new File(Utility.getProperty("Excel_Sheet_Path"));
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		Thread.sleep(3000);
		//Enter the hourly Sale report Url
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/hourlySale");

		Thread.sleep(5000);
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

		Thread.sleep(5000);
		if(driver.findElement(By.xpath("//h3[contains(.,'No')]")).isDisplayed())
		{
			
		}

		else
		{
	        //No.of rows
	        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
			
			//Get the net_Sales_Amount
			String net_Sales_Amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
			//double netSaleAmount = Double.parseDouble(netSales);
			sheet1.getRow(8).createCell(1).setCellValue(net_Sales_Amount);
			
			//Get the Tax Amount
			String tax_Amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
			//double netSaleAmount = Double.parseDouble(netSales);
			sheet1.getRow(8).createCell(14).setCellValue(tax_Amount);
			
			//Get the Discount Amount
			String disc_Amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]/span")).getText();
			sheet1.getRow(8).createCell(28).setCellValue(disc_Amount);
		}
		
		FileOutputStream fout = new FileOutputStream(src);
		
		wb.write(fout);
		
		wb.close();
	}

	@Test(priority=10,enabled=true)
	public void getTheValue_Of_Daily_Sale_Report() throws Exception
	{
		
		
		File src = new File(Utility.getProperty("Excel_Sheet_Path"));
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		Thread.sleep(3000);
		//Enter the Daily Sale report Url
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/dailySale");

		Thread.sleep(5000);
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

		Thread.sleep(5000);
		if(driver.findElement(By.xpath("//h3[contains(.,'No')]")).isDisplayed())
		{
			
		}

		else
		{
	        //No.of rows
	        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
			
			//Get the Net Sales Amount
			String net_Sales_Amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[2]/span")).getText();
			//double netSaleAmount = Double.parseDouble(netSales);
			sheet1.getRow(9).createCell(1).setCellValue(net_Sales_Amount);
			
			//Get the Tax Amount
			String tax_Amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
			//double netSaleAmount = Double.parseDouble(netSales);
			sheet1.getRow(9).createCell(14).setCellValue(tax_Amount);
			
			//Get the Discount Amount
			String disc_Amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
			sheet1.getRow(9).createCell(28).setCellValue(disc_Amount);
		}
		
		FileOutputStream fout = new FileOutputStream(src);
		
		wb.write(fout);
		
		wb.close();
	}

	@Test(priority=11,enabled=true)
	public void getTheValue_Of_Cashier_Report() throws Exception
	{
		
		
		File src = new File(Utility.getProperty("Excel_Sheet_Path"));
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		Thread.sleep(3000);
		//Enter the cashierOut Url
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/cashierOut");

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
		String netSales = driver.findElement(By.xpath("//div[contains(.,'Net Sales')]/span")).getText();
		//double netSaleAmount = Double.parseDouble(netSales);
		sheet1.getRow(10).createCell(1).setCellValue(netSales);
		
		//Get the count of Tax
		List<WebElement> taxRow = driver.findElements(By.xpath("//b[.='TAXES']/../../../div"));
		//int numTax = taxRow.size() - 3;//Here 3 for 3 rows of headings
		int j = 2;
		//Get all the details of rows
		for(int i = 3; i < taxRow.size(); i++)
		{
			
			for(int k = 1; k <= 4;k++)
			{
				//Get the values of Tax
				String name = driver.findElement(By.xpath("//b[.='TAXES']/../../../div["+i+"]/div["+k+"]")).getText();
				sheet1.getRow(10).createCell(j).setCellValue(name);

				j++;
			}
			
		}
				
		//Get the Total Tax Amount
		String total_tax = driver.findElement(By.xpath("//b[.='TAXES']/../../../div/div[contains(.,'TOTAL')]/../div[4]")).getText();
		//double netSaleAmount = Double.parseDouble(netSales);
		sheet1.getRow(10).createCell(14).setCellValue(total_tax);
		int l = 15;
		//Get all the details of rows
		for(int i = 3; i < taxRow.size(); i++)
		{
			
			//Get the Value of Tax Exempt
			String name = driver.findElement(By.xpath("//b[.='TAXES']/../../../div["+i+"]/div[5]")).getText();
			sheet1.getRow(10).createCell(l).setCellValue(name);
			l++;
			 
		}
		
		//Get the Total Tax Exempt Amount
		String total_tax_exempt = driver.findElement(By.xpath("//b[.='TAXES']/../../../div/div[contains(.,'TOTAL')]/../div[5]")).getText();
		//double netSaleAmount = Double.parseDouble(netSales);
		sheet1.getRow(10).createCell(18).setCellValue(total_tax_exempt);
		
		//Get the CC Sales amount
		String cc_sales_amount = driver.findElement(By.xpath("//b[.='CREDIT CARD']/../../../div/div[contains(.,'TOTAL')]/../div[3]")).getText();
		sheet1.getRow(10).createCell(19).setCellValue(cc_sales_amount);
		
		//Get the CC Tips amount
		String cc_tips_amount = driver.findElement(By.xpath("//b[.='CREDIT CARD']/../../../div/div[contains(.,'TOTAL')]/../div[4]")).getText();
		sheet1.getRow(10).createCell(20).setCellValue(cc_tips_amount);
		
		try {
			//Get the Gratuity amount
			String Gratuity = driver.findElement(By.xpath("//b[.='TIP / GRATUITY ']/../../..//div[contains(.,'Gratuity')]/span")).getText();
			sheet1.getRow(10).createCell(21).setCellValue(Gratuity);
		} catch (Exception e) {}
		
		try {
			//Get the Employee Tip amount
			String employee_Tip = driver.findElement(By.xpath("//b[.='TIP / GRATUITY ']/../../..//div[contains(.,'Employee Tip')]/span")).getText();
			sheet1.getRow(10).createCell(22).setCellValue(employee_Tip);
		} catch (Exception e) {}
		
		try {
			//Get the House Account amount
			String house_Account = driver.findElement(By.xpath("//b[.='TIP / GRATUITY ']/../../..//div[contains(.,'House Account')]/span")).getText();
			sheet1.getRow(10).createCell(23).setCellValue(house_Account);
		} catch (Exception e) {}
		
		try {
			//Get the GiveX Tip amount
			String GiveXTip = driver.findElement(By.xpath("//b[.='TIP / GRATUITY ']/../../..//div[contains(.,'GiveX')]/span")).getText();
			sheet1.getRow(10).createCell(24).setCellValue(GiveXTip);
		} catch (Exception e) {}
		
		try {
			//Get the Gift Card Tip amount
			String GiftCardTipAmount = driver.findElement(By.xpath("//b[.='TIP / GRATUITY ']/../../..//div[contains(.,'Gift Card')]/span")).getText();
			sheet1.getRow(10).createCell(25).setCellValue(GiftCardTipAmount);
		} catch (Exception e) {}
		
		try {
			//Get the Tip Charge amount
			String tip_Charge = driver.findElement(By.xpath("//b[.='TIP / GRATUITY ']/../../..//div[contains(.,'Tip Charge')]/span")).getText();
			sheet1.getRow(10).createCell(26).setCellValue(tip_Charge);
		} catch (Exception e) {}
		
		try {
			//Get the Driver Tip amount
			String driver_Tip = driver.findElement(By.xpath("//b[.='TIP / GRATUITY ']/../../..//div[contains(.,'Driver Tip')]/span")).getText();
			sheet1.getRow(10).createCell(27).setCellValue(driver_Tip);
		} catch (Exception e) {}
		
		try {
			//Get the Discount amount
			String disc_Amount = driver.findElement(By.xpath("//b[contains(.,'DISCOUNT')]/../../../div[contains(.,'TOTAL')]/span")).getText();
			sheet1.getRow(10).createCell(28).setCellValue(disc_Amount);
		} catch (Exception e) {}
		
		FileOutputStream fout = new FileOutputStream(src);
		
		wb.write(fout);
		
		wb.close();
	}

	@Test(priority=12,enabled=true)
	public void getTheValue_Of_Sale_Summary_Report() throws Exception
	{
		
		
		File src = new File(Utility.getProperty("Excel_Sheet_Path"));
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		Thread.sleep(3000);
		//Enter the Daily Sale report Url
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/saleSummary");

		Thread.sleep(5000);
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
		
/*		Thread.sleep(3000);
		//Click the OrderType 		
		driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul")).click();
		Thread.sleep(3000);
		//Enter the Service_Type
		driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Utility.getReportProperty("Service_Type"));
		
		Thread.sleep(3000);
		//Press the Service Type
		driver.findElement(By.xpath("//form[@name='saleReport']/div[5]/div/div/ul/li/input")).sendKeys(Keys.ENTER);
*/		
		Thread.sleep(2000);
		//Click the Run Button
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(5000);
		if(driver.findElement(By.xpath("//h3[contains(.,'No')]")).isDisplayed())
		{
			
		}

		else
		{
	        //No.of rows
	        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
			
			//Get the net sales Amount
			String netSales_Amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[3]/span")).getText();
			//double netSaleAmount = Double.parseDouble(netSales);
			sheet1.getRow(11).createCell(1).setCellValue(netSales_Amount);
			
			//Get the Tax Amount
			String tax_Amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]/span")).getText();
			//double netSaleAmount = Double.parseDouble(netSales);
			sheet1.getRow(11).createCell(14).setCellValue(tax_Amount);
			
			//Get the Discount Amount
			String disc_Amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[7]/span")).getText();
			sheet1.getRow(11).createCell(28).setCellValue(disc_Amount);
		}
		
		FileOutputStream fout = new FileOutputStream(src);
		
		wb.write(fout);
		
		wb.close();
	}

	@Test(priority=13,enabled=true)
	public void getTheValue_Of_Transaction_Report() throws Exception
	{
		
		
		File src = new File(Utility.getProperty("Excel_Sheet_Path"));
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		Thread.sleep(3000);
		//Enter the transactionSale report Url
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"report/transactionSale");

		Thread.sleep(5000);
		//Select the Tender option
		Select tenderOption = new Select(driver.findElement(By.xpath("//form[@name='transactionSale']/div[1]/div/select")));
		tenderOption.selectByVisibleText("By Tender Name");
		
		Thread.sleep(5000);
		//Click the Tender Name option
		driver.findElement(By.xpath("//form[@name='transactionSale']/div[2]/div/div/a")).click();
		//Enter the required Tender Name
		driver.findElement(By.xpath("//form[@name='transactionSale']/div[2]/div/div/div/div/input")).sendKeys("All");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='transactionSale']/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	
		Thread.sleep(3000);
		//Click the Time Period option
		driver.findElement(By.xpath("//form[@name='transactionSale']/div[3]/div/div/a")).click();
		//Enter the required Time Period
		driver.findElement(By.xpath("//form[@name='transactionSale']/div[3]/div/div/div/div/input")).sendKeys("Date Range");
		//Press the Enter Key
		driver.findElement(By.xpath("//form[@name='transactionSale']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Clear the date field
		driver.findElement(By.xpath("//form[@name='transactionSale']/div[4]/div/div/input[1]")).clear();
		//Enter the date
		driver.findElement(By.xpath("//form[@name='transactionSale']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

		Thread.sleep(2000);
		//Clear the date field
		driver.findElement(By.xpath("//form[@name='transactionSale']/div[4]/div/div/input[2]")).clear();
		//Enter the date
		driver.findElement(By.xpath("//form[@name='transactionSale']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(2000);
		//Click the Run Button
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(5000);
		if(driver.findElement(By.xpath("//h3[contains(.,'No')]")).isDisplayed())
		{
			
		}

		else
		{
	        //No.of rows
	        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr/td[8]"));
	       	        
			//Get the CC Tip Amount
			String ccTipAmount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr["+rows.size()+"]/td[8]")).getText();
			//double netSaleAmount = Double.parseDouble(netSales);
			sheet1.getRow(12).createCell(20).setCellValue(ccTipAmount);
			
		}		
		FileOutputStream fout = new FileOutputStream(src);
		
		wb.write(fout);
		
		wb.close();
	}

	@Test(priority=14,enabled=true)
	public void getTheValue_Of_Tax_Report() throws Exception
	{
		
		
		File src = new File(Utility.getProperty("Excel_Sheet_Path"));
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		Thread.sleep(3000);
		//Enter the taxReport report Url
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"taxReport");

		Thread.sleep(5000);
		//Select the Time Period option
	    driver.findElement(By.xpath("//form[@name='taxReport']/div[1]/div/div/a")).click();
	    //Enter the required Period of time for Specific date
	    driver.findElement(By.xpath("//form[@name='taxReport']/div[1]/div/div/div/div/input")).sendKeys("Date Range");
	    //Press the Enter key
	    driver.findElement(By.xpath("//form[@name='taxReport']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);

	    //Clear the Date field
	    driver.findElement(By.xpath("//form[@name='taxReport']/div[2]/div/div/input[1]")).clear();
	    //Enter the required date
	    driver.findElement(By.xpath("//form[@name='taxReport']/div[2]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

	    //Clear the Date field
	    driver.findElement(By.xpath("//form[@name='taxReport']/div[2]/div/div/input[2]")).clear();
	    //Enter the required date
	    driver.findElement(By.xpath("//form[@name='taxReport']/div[2]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
		
		Thread.sleep(2000);
		//Click the Run Button
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(10000);
        //No.of rows
		List<WebElement> rowss = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr"));
        		
		int j = 2;
		//Get all the details of rows
		for(int i = 2; i < rowss.size(); i++)
		{
			
			for(int k = 1; k <= 4;k++)
			{
				//Get the values of Tax
				String name = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr["+i+"]/td["+k+"]")).getText();
				sheet1.getRow(13).createCell(j).setCellValue(name);

				j++;
			}
			
		}
				
		//Get the Tax Amount
		String tax_Amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr["+rowss.size()+"]/th[4]")).getText();
		//double netSaleAmount = Double.parseDouble(netSales);
		sheet1.getRow(13).createCell(14).setCellValue(tax_Amount);
		
		int l = 15;
		//Get all the details of rows
		for(int i = 3; i < rowss.size(); i++)
		{
			
			//Get the Value of Tax Exempt
			String name = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr["+i+"]/td[5]")).getText();
			sheet1.getRow(13).createCell(l).setCellValue(name);
			l++;
			 
		}
		
		//Get the Tax Exempt Amount
		String tax_Exempt_Amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive']/tbody/tr["+rowss.size()+"]/th[5]")).getText();
		//double netSaleAmount = Double.parseDouble(netSales);
		sheet1.getRow(13).createCell(18).setCellValue(tax_Exempt_Amount);
				
		FileOutputStream fout = new FileOutputStream(src);
		
		wb.write(fout);
		
		wb.close();
	}

	@Test(priority=15, enabled=true)
	public void getTheValue_Of_Payroll_Report() throws Exception
	{
		
		File src = new File(Utility.getProperty("Excel_Sheet_Path"));
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		Thread.sleep(3000);
		//Enter the roleBasedPayroll report Url
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id")+"roleBasedPayroll");

		Thread.sleep(5000);
		Thread.sleep(1000);
		//Select the Employee option
	    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/a")).click();
	    //Enter the required Employee
	    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/div/div/input")).sendKeys("All");
	    //Press the Enter key
	    driver.findElement(By.xpath("//form[@name='payRoll']/div[1]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	  
	    //Select the Process as Daily
		Select process = new Select(driver.findElement(By.xpath("//form[@name='payRoll']/div[2]/div/select")));
		process.selectByVisibleText("Weekly");
			
  	    //Thread.sleep(1000);
	    //Select the Specific date Time Period option
	    driver.findElement(By.xpath("//form[@name='payRoll']/div[3]/div/div/a")).click();
	    //Enter the required Period of time
	    driver.findElement(By.xpath("//form[@name='payRoll']/div[3]/div/div/div/div/input")).sendKeys("Date Range");
	    //Press the Enter key
	    driver.findElement(By.xpath("//form[@name='payRoll']/div[3]/div/div/div/div/input")).sendKeys(Keys.ENTER);

	    Thread.sleep(3000);
	    //Clear the Date field
	    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[1]")).clear();
	    //Enter the Date
	    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[1]")).sendKeys(Utility.getReportProperty("Date_Range_From"));

	    Thread.sleep(1000);
	    //Clear the Date field
	    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[2]")).clear();
	    //Enter the Date
	    driver.findElement(By.xpath("//form[@name='payRoll']/div[4]/div/div/input[2]")).sendKeys(Utility.getReportProperty("Date_Range_To"));
	    Thread.sleep(1000);
	    
	    //Select the Format option
	    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/a")).click();
	    //Enter the required Format
	    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/div/div/input")).sendKeys("In Hours");
	    //Press the Enter key
	    driver.findElement(By.xpath("//form[@name='payRoll']/div[5]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	    
	    //Select the Active/Inactive option
	    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/a")).click();
	    //Enter the required Format
	    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/div/div/input")).sendKeys("All");
	    //Press the Enter key
	    driver.findElement(By.xpath("//form[@name='payRoll']/div[6]/div/div/div/div/input")).sendKeys(Keys.ENTER);

	    Thread.sleep(1000);
	    //Select the Process as Daily
		Select sort1 = new Select(driver.findElement(By.xpath("//form[@name='payRoll']/div[7]/div/select")));
		sort1.selectByVisibleText("A-Z LastName");
		
	    //Select the Role option
	    driver.findElement(By.xpath("//form[@name='payRoll']/div[8]/div/div/a")).click();
	    //Enter the required Role
	    driver.findElement(By.xpath("//form[@name='payRoll']/div[8]/div/div/div/div/input")).sendKeys("All");
	    //Press the Enter key
	    driver.findElement(By.xpath("//form[@name='payRoll']/div[8]/div/div/div/div/input")).sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//Click the Run Button
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(15000);
		if(driver.findElement(By.xpath("//h3[contains(.,'No')]")).isDisplayed())
		{
			
		}

		else
		{
	        //No.of rows
	        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	       
			//Get the netSales Amount
			String netSales_Amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[16]")).getText().replaceAll("[a-zA-Z $ ₹ :]", "");
			//double netSaleAmount = Double.parseDouble(netSales);
			sheet1.getRow(14).createCell(1).setCellValue(netSales_Amount);
						
			//Get the cc tip Amount
			String cc_tip_Amount = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[11]")).getText().replaceAll("[a-zA-Z $ ₹ :]", "");
			//double netSaleAmount = Double.parseDouble(netSales);
			sheet1.getRow(14).createCell(20).setCellValue(cc_tip_Amount);
			
			//Get the gratuity Amount
			String gratuity = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[12]")).getText().replaceAll("[a-zA-Z $ ₹ :]", "");
			//double netSaleAmount = Double.parseDouble(netSales);
			sheet1.getRow(14).createCell(21).setCellValue(gratuity);
		}
		
		FileOutputStream fout = new FileOutputStream(src);
		
		wb.write(fout);
		
		wb.close();
	}

	@Test(priority=16,enabled=true)
	public void diff() throws Exception
	{		
		File src = new File(Utility.getProperty("Excel_Sheet_Path"));
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		for(int i = 1; i <= 30; i++)
		{
			for(int j = 17; j <= 24; j++)
			{
				sheet1.getRow(j).createCell(i).setCellValue("0");
			}
			
		}

		for(int j = 2; j <= 14; j++)
		{
			if(sheet1.getRow(j).getCell(1).getStringCellValue().equals("-")){}
			else{
			String nsale = sheet1.getRow(j).getCell(1).getStringCellValue().replaceAll("[a-zA-Z $ ₹ , :]", "");
			double netsale = Double.parseDouble(nsale);
			sheet1.getRow(j).createCell(1).setCellValue(netsale);
			}
		}
		for(int j = 2; j <= 14; j++)
		{
			if(sheet1.getRow(j).getCell(29).getStringCellValue().equals("-")){}
			else{
			String dnsale = sheet1.getRow(j).getCell(29).getStringCellValue().replaceAll("[a-zA-Z $ ₹ , :]", "");
			double dnetsale = Double.parseDouble(dnsale);
			sheet1.getRow(j).createCell(29).setCellValue(dnetsale);
			}
		}
		for(int j = 2; j <= 14; j++)
		{
			if(sheet1.getRow(j).getCell(30).getStringCellValue().equals("-")){}
			else{
			String cnsale = sheet1.getRow(j).getCell(30).getStringCellValue().replaceAll("[a-zA-Z $ ₹ , :]", "");
			double cnetsale = Double.parseDouble(cnsale);
			sheet1.getRow(j).createCell(30).setCellValue(cnetsale);
			}
		}
		for(int j = 2; j <= 14; j++)
		{
			if(sheet1.getRow(j).getCell(14).getStringCellValue().equals("-")){}
			else{
			String tax = sheet1.getRow(j).getCell(14).getStringCellValue().replaceAll("[a-zA-Z $ ₹ , :]", "");
			double ttax = Double.parseDouble(tax);
			sheet1.getRow(j).createCell(14).setCellValue(ttax);
			}
		}		
		for(int j = 2; j <= 14; j++)
		{
			if(sheet1.getRow(j).getCell(18).getStringCellValue().equals("-")){}
			else{
			String taxexempt = sheet1.getRow(j).getCell(18).getStringCellValue().replaceAll("[a-zA-Z $ ₹ , :]", "");
			double ttaxexempt = Double.parseDouble(taxexempt);
			sheet1.getRow(j).createCell(18).setCellValue(ttaxexempt);
			}
		}
		for(int j = 2; j <= 14; j++)
		{
			if(sheet1.getRow(j).getCell(19).getStringCellValue().equals("-")){}
			else{
			String ccSales = sheet1.getRow(j).getCell(19).getStringCellValue().replaceAll("[a-zA-Z $ ₹ , :]", "");
			double tccSales = Double.parseDouble(ccSales);
			sheet1.getRow(j).createCell(19).setCellValue(tccSales);
			}
		}
		for(int j = 2; j <= 14; j++)
		{
			if(sheet1.getRow(j).getCell(20).getStringCellValue().equals("-")){}
			else{
			String tips = sheet1.getRow(j).getCell(20).getStringCellValue().replaceAll("[a-zA-Z $ ₹ , :]", "");
			double ttips = Double.parseDouble(tips);
			sheet1.getRow(j).createCell(20).setCellValue(ttips);
			}
		}
		for(int j = 2; j <= 14; j++)
		{
			if(sheet1.getRow(j).getCell(21).getStringCellValue().equals("-")){}
			else{
			String gratuity = sheet1.getRow(j).getCell(21).getStringCellValue().replaceAll("[a-zA-Z $ ₹ , :]", "");
			double tgratuity = Double.parseDouble(gratuity);
			sheet1.getRow(j).createCell(21).setCellValue(tgratuity);
			}
		}
		for(int j = 2; j <= 14; j++)
		{
			if(sheet1.getRow(j).getCell(28).getStringCellValue().equals("-")){}
			else{
			String disc_amount = sheet1.getRow(j).getCell(28).getStringCellValue().replaceAll("[a-zA-Z $ ₹ , :]", "");
			double tdisc_amount = Double.parseDouble(disc_amount);
			sheet1.getRow(j).createCell(28).setCellValue(tdisc_amount);
			}
		}
		
		try{
		//Check whether the Net sales of Sales Recap Report and Department sale Report 
		if(sheet1.getRow(2).getCell(1).getNumericCellValue() == sheet1.getRow(3).getCell(1).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(1).getNumericCellValue() - sheet1.getRow(3).getCell(1).getNumericCellValue();
			sheet1.getRow(17).getCell(1).setCellValue(diff);
		}}catch(Exception e){}
		
		try{
		//Check whether the Net sales of Sales Recap Report and Department Summary of Sale Recap Reports are same or not 
		if(sheet1.getRow(2).getCell(1).getNumericCellValue() == sheet1.getRow(2).getCell(29).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(1).getNumericCellValue() - sheet1.getRow(2).getCell(29).getNumericCellValue();
			sheet1.getRow(17).getCell(29).setCellValue(diff);
		}}catch(Exception e){}
		
		try{
			//Check whether the Net sales of Sales Recap Report and Category Summary of Sale Recap Reports are same or not
		if(sheet1.getRow(2).getCell(1).getNumericCellValue() == sheet1.getRow(2).getCell(30).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(1).getNumericCellValue() - sheet1.getRow(2).getCell(30).getNumericCellValue();
			sheet1.getRow(17).getCell(30).setCellValue(diff);
		}}catch(Exception e){}
		
		try{
		//Check whether the Net sales of Sales Recap Report and Category sale Report 
		if(sheet1.getRow(2).getCell(1).getNumericCellValue() == sheet1.getRow(4).getCell(1).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(1).getNumericCellValue() - sheet1.getRow(4).getCell(1).getNumericCellValue();
			sheet1.getRow(18).getCell(1).setCellValue(diff);
		}}catch(Exception e){}
		
		try{
		//Check whether the Net sales of Sales Recap Report and Menu Item sale Report 
		if(sheet1.getRow(2).getCell(1).getNumericCellValue() == sheet1.getRow(6).getCell(1).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(1).getNumericCellValue() - sheet1.getRow(6).getCell(1).getNumericCellValue();
			sheet1.getRow(19).getCell(1).setCellValue(diff);
		}}catch(Exception e){}
		
		try{
		//Check whether the Net sales of Sales Recap Report and Hourly sale Report 
		if(sheet1.getRow(2).getCell(1).getNumericCellValue() == sheet1.getRow(8).getCell(1).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(1).getNumericCellValue() - sheet1.getRow(8).getCell(1).getNumericCellValue();
			sheet1.getRow(20).getCell(1).setCellValue(diff);
		}}catch(Exception e){}
		
		try{
		//Check whether the Net sales of Sales Recap Report and Daily sale Report 
		if(sheet1.getRow(2).getCell(1).getNumericCellValue() == sheet1.getRow(9).getCell(1).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(1).getNumericCellValue() - sheet1.getRow(9).getCell(1).getNumericCellValue();
			sheet1.getRow(21).getCell(1).setCellValue(diff);
		}}catch(Exception e){}
		
		try{
		//Check whether the Net sales of Sales Recap Report and Cashier Out Report 
		if(sheet1.getRow(2).getCell(1).getNumericCellValue() == sheet1.getRow(10).getCell(1).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(1).getNumericCellValue() - sheet1.getRow(10).getCell(1).getNumericCellValue();
			sheet1.getRow(22).getCell(1).setCellValue(diff);
		}}catch(Exception e){}
		
		try{
		//Check whether the Net sales of Sales Recap Report and Sales Summary Report 
		if(sheet1.getRow(2).getCell(1).getNumericCellValue() == sheet1.getRow(11).getCell(1).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(1).getNumericCellValue() - sheet1.getRow(11).getCell(1).getNumericCellValue();
			sheet1.getRow(23).getCell(1).setCellValue(diff);
		}}catch(Exception e){}
		
		try{
		//Check whether the Tax of Sales Recap Report and Department sale Report 
		if(sheet1.getRow(2).getCell(14).getNumericCellValue() == sheet1.getRow(3).getCell(14).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(14).getNumericCellValue() - sheet1.getRow(3).getCell(14).getNumericCellValue();
			sheet1.getRow(17).getCell(14).setCellValue(diff);
		}}catch(Exception e){}
		
		try{
		//Check whether the Tax of Sales Recap Report and Category sale Report 
		if(sheet1.getRow(2).getCell(14).getNumericCellValue() == sheet1.getRow(4).getCell(14).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(14).getNumericCellValue() - sheet1.getRow(4).getCell(14).getNumericCellValue();
			sheet1.getRow(18).getCell(14).setCellValue(diff);
		}}catch(Exception e){}
		
		try{
		//Check whether the Tax of Sales Recap Report and Menu Item sale Report 
		if(sheet1.getRow(2).getCell(14).getNumericCellValue() == sheet1.getRow(6).getCell(14).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(14).getNumericCellValue() - sheet1.getRow(6).getCell(14).getNumericCellValue();
			sheet1.getRow(19).getCell(14).setCellValue(diff);
		}}catch(Exception e){}
		
		try{
		//Check whether the Tax of Sales Recap Report and Hourly sale Report 
		if(sheet1.getRow(2).getCell(14).getNumericCellValue() == sheet1.getRow(8).getCell(14).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(14).getNumericCellValue() - sheet1.getRow(8).getCell(14).getNumericCellValue();
			sheet1.getRow(20).getCell(14).setCellValue(diff);
		}}catch(Exception e){}
		
		try{
		//Check whether the Tax of Sales Recap Report and Daily sale Report 
		if(sheet1.getRow(2).getCell(14).getNumericCellValue() == sheet1.getRow(9).getCell(14).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(14).getNumericCellValue() - sheet1.getRow(9).getCell(14).getNumericCellValue();
			sheet1.getRow(21).getCell(14).setCellValue(diff);
		}}catch(Exception e){}
		
		try{
		//Check whether the Tax of Sales Recap Report and Cashier Out Report 
		if(sheet1.getRow(2).getCell(14).getNumericCellValue() == sheet1.getRow(10).getCell(14).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(14).getNumericCellValue() - sheet1.getRow(10).getCell(14).getNumericCellValue();
			sheet1.getRow(22).getCell(14).setCellValue(diff);
		}}catch(Exception e){}
		
		try{
		//Check whether the Tax of Sales Recap Report and Sales Summary Report 
		if(sheet1.getRow(2).getCell(14).getNumericCellValue() == sheet1.getRow(11).getCell(14).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(14).getNumericCellValue() - sheet1.getRow(11).getCell(14).getNumericCellValue();
			sheet1.getRow(23).getCell(14).setCellValue(diff);
		}}catch(Exception e){}
		
		try{
		//Check whether the Tax of Sales Recap Report and Tax Report 
		if(sheet1.getRow(2).getCell(14).getNumericCellValue() == sheet1.getRow(13).getCell(14).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(14).getNumericCellValue() - sheet1.getRow(13).getCell(14).getNumericCellValue();
			sheet1.getRow(24).getCell(14).setCellValue(diff);
		}}catch(Exception e){}
		
		try{
		//Check whether the Tax Exempt of Sales Recap Report and Cashier Report 
		if(sheet1.getRow(2).getCell(18).getNumericCellValue() == sheet1.getRow(10).getCell(18).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(18).getNumericCellValue() - sheet1.getRow(10).getCell(18).getNumericCellValue();
			sheet1.getRow(22).getCell(18).setCellValue(diff);
		}}catch(Exception e){}
		
		try{
		//Check whether the Tax of Sales Recap Report and Tax Report 
		if(sheet1.getRow(2).getCell(18).getNumericCellValue() == sheet1.getRow(13).getCell(18).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(18).getNumericCellValue() - sheet1.getRow(13).getCell(18).getNumericCellValue();
			sheet1.getRow(24).getCell(18).setCellValue(diff);
		}}catch(Exception e){}
		
		try{
		//Check whether the CC Sales of Sales Recap Report and Cashier Report 
		if(sheet1.getRow(2).getCell(19).getNumericCellValue() == sheet1.getRow(10).getCell(19).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(19).getNumericCellValue() - sheet1.getRow(10).getCell(19).getNumericCellValue();
			sheet1.getRow(22).getCell(19).setCellValue(diff);
		}}catch(Exception e){}
		
		try{
		//Check whether the CC Tips of Sales Recap Report and Cashier Report 
		if(sheet1.getRow(2).getCell(20).getNumericCellValue() == sheet1.getRow(10).getCell(20).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(20).getNumericCellValue() - sheet1.getRow(10).getCell(20).getNumericCellValue();
			sheet1.getRow(22).getCell(20).setCellValue(diff);
		}}catch(Exception e){}
		
		try{
		//Check whether the Gratuity of Sales Recap Report and Cashier Report 
		if(sheet1.getRow(2).getCell(21).getNumericCellValue() == sheet1.getRow(10).getCell(21).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(21).getNumericCellValue() - sheet1.getRow(10).getCell(21).getNumericCellValue();
			sheet1.getRow(22).getCell(21).setCellValue(diff);
		}}catch(Exception e){}
		
		try{
		//Check whether the Discount of Sales Recap Report and Department sale Report 
		if(sheet1.getRow(2).getCell(28).getNumericCellValue() == sheet1.getRow(3).getCell(28).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(28).getNumericCellValue() - sheet1.getRow(3).getCell(28).getNumericCellValue();
			sheet1.getRow(17).getCell(28).setCellValue(diff);
		}}catch(Exception e){}
		
		try{
		//Check whether the Discount of Sales Recap Report and Category sale Report 
		if(sheet1.getRow(2).getCell(28).getNumericCellValue() == sheet1.getRow(4).getCell(28).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(28).getNumericCellValue() - sheet1.getRow(4).getCell(28).getNumericCellValue();
			sheet1.getRow(18).getCell(28).setCellValue(diff);
		}}catch(Exception e){}
		
		try{
		//Check whether the Discount of Sales Recap Report and Menu Item sale Report 
		if(sheet1.getRow(2).getCell(28).getNumericCellValue() == sheet1.getRow(6).getCell(28).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(28).getNumericCellValue() - sheet1.getRow(6).getCell(28).getNumericCellValue();
			sheet1.getRow(19).getCell(28).setCellValue(diff);
		}}catch(Exception e){}
		
		try{
		//Check whether the Discount of Sales Recap Report and Hourly sale Report 
		if(sheet1.getRow(2).getCell(28).getNumericCellValue() == sheet1.getRow(8).getCell(28).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(28).getNumericCellValue() - sheet1.getRow(8).getCell(28).getNumericCellValue();
			sheet1.getRow(20).getCell(28).setCellValue(diff);
		}}catch(Exception e){}
		
		try{
		//Check whether the Discount of Sales Recap Report and Daily sale Report 
		if(sheet1.getRow(2).getCell(28).getNumericCellValue() == sheet1.getRow(9).getCell(28).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(28).getNumericCellValue() - sheet1.getRow(9).getCell(28).getNumericCellValue();
			sheet1.getRow(21).getCell(28).setCellValue(diff);
		}}catch(Exception e){}
		
		try{
		//Check whether the Discount of Sales Recap Report and Cashier Out Report 
		if(sheet1.getRow(2).getCell(28).getNumericCellValue() == sheet1.getRow(10).getCell(28).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(28).getNumericCellValue() - sheet1.getRow(10).getCell(28).getNumericCellValue();
			sheet1.getRow(22).getCell(28).setCellValue(diff);
		}}catch(Exception e){}
		
		try{
		//Check whether the Discount of Sales Recap Report and Sales Summary Report 
		if(sheet1.getRow(2).getCell(28).getNumericCellValue() == sheet1.getRow(11).getCell(28).getNumericCellValue())
		{}
		else
		{
			double diff = sheet1.getRow(2).getCell(28).getNumericCellValue() - sheet1.getRow(11).getCell(28).getNumericCellValue();
			sheet1.getRow(23).getCell(28).setCellValue(diff);
		}}catch(Exception e){}
		
		FileOutputStream fout = new FileOutputStream(src);
		
		wb.write(fout);
		
		wb.close();
	}
}
