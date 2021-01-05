package templates;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

public class Finding_Duplicate_Dept_Cat_SubCat_Mod_Menu_Retail {

	public WebDriver driver;
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Finding_Duplicate_Dept_Cat_SubCat_Mod_Menu_Retail");
	
	@AfterClass
	public void flushTest() throws Exception
	{
		Thread.sleep(2000);
		rep.endTest(test);
		rep.flush();
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
		driver.findElement(By.name("txtusername")).sendKeys("admin@baophan.com");
		//Clear the password from the password text box
		driver.findElement(By.name("txtpassword")).clear();
		//Enter the password
		driver.findElement(By.name("txtpassword")).sendKeys("welcome123");
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

/*	@Test(priority=2)
	public void all() throws Exception
	{
		for(int a = 13; a <= 20; a++)
		{
			DecimalFormat formatter = new DecimalFormat("00");
			String aFormatted = formatter.format(a);
			String fdate = aFormatted+"-May-2019";
			System.out.println("Report For : "+fdate);
			
			apply_Not_Applicable(fdate);

			SendMail.snedMailWithExcelAttachment();
		}
	}
*/	
	
	@Test(priority=2)
	public void apply_Not_Applicable() throws Exception
	{

			Thread.sleep(15000);
			String storeName = driver.findElement(By.xpath("//div[@id='navigation']/ul/li/a/span")).getText();
			storeName = storeName.concat("'s Menu WB");
			System.out.println(storeName);

			Thread.sleep(5000);
			//Click the Products/Items option
			driver.findElement(By.xpath("//div/ul/li/a/span[.='Products/Items']")).click();
			
			Thread.sleep(2000);
			//Click the Import/Export button
			driver.findElement(By.xpath("//span[contains(.,'Import/Export')]")).click();
			
			Thread.sleep(1000);
			//Click the Download Data from that store
			driver.findElement(By.xpath("//p[.='Download Data']")).click();Thread.sleep(15000);
			driver.getCurrentUrl();
			
			File src = new File("C:\\Users\\hariprasanth_j\\Downloads\\"+storeName+".xlsx");
			
			//System.out.println("Store Id : 58615674d5ceb77c75fb44b3");
			//File src = new File("C:\\Users\\hariprasanth_j\\Downloads\\.xlsx");
			FileInputStream fis = new FileInputStream(src);
			
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			XSSFSheet sheet1 = wb.getSheet("Menu Item");
			int rowCount = sheet1.getLastRowNum();
			for(int i = 1; i <= rowCount; i++)
			{
				String s1 = sheet1.getRow(i).getCell(0).getStringCellValue();
				
				for(int j = 1; j <= rowCount; j++)
				{
					
					if(i == j)
					{}
					else
					{String s2 = sheet1.getRow(j).getCell(0).getStringCellValue();
						if(s1.equals(s2))
						{
							System.out.println("Repeated Menu Item : "+s2);break;
						}
						else
						{
						}
					}
				}
			}
			
			XSSFSheet sheet2 = wb.getSheet("Department");
			int rowCount2 = sheet2.getLastRowNum();
			for(int i = 1; i <= rowCount2; i++)
			{
				String s1 = sheet2.getRow(i).getCell(0).getStringCellValue();
				
				for(int j = 1; j <= rowCount2; j++)
				{
					
					if(i == j)
					{}
					else
					{String s2 = sheet2.getRow(j).getCell(0).getStringCellValue();
						if(s1.equals(s2))
						{
							System.out.println("Repeated Department : "+s2);break;
						}
						else
						{
						}
					}
				}
			}
			
			XSSFSheet sheet3 = wb.getSheet("Category");
			int rowCount3 = sheet3.getLastRowNum();
			for(int i = 1; i <= rowCount3; i++)
			{
				String s1 = sheet3.getRow(i).getCell(0).getStringCellValue();
				
				for(int j = 1; j <= rowCount3; j++)
				{
					
					if(i == j)
					{}
					else
					{String s2 = sheet3.getRow(j).getCell(0).getStringCellValue();
						if(s1.equals(s2))
						{
							System.out.println("Repeated Category : "+s2);break;
						}
						else
						{
						}
					}
				}
			}
			
			XSSFSheet sheet4 = wb.getSheet("Sub category");
			int rowCount4 = sheet4.getLastRowNum();
			for(int i = 1; i <= rowCount4; i++)
			{
				String s1 = sheet4.getRow(i).getCell(0).getStringCellValue();
				
				for(int j = 1; j <= rowCount4; j++)
				{
					
					if(i == j)
					{}
					else
					{String s2 = sheet4.getRow(j).getCell(0).getStringCellValue();
						if(s1.equals(s2))
						{
							System.out.println("Repeated Sub Category : "+s2);break;
						}
						else
						{
						}
					}
				}
			}
			
			XSSFSheet sheet5 = wb.getSheet("Retail Item");
			int rowCount5 = sheet5.getLastRowNum();
			for(int i = 1; i <= rowCount5; i++)
			{
				String s1 = sheet5.getRow(i).getCell(0).getStringCellValue();
				
				for(int j = 1; j <= rowCount5; j++)
				{
					
					if(i == j)
					{}
					else
					{String s2 = sheet5.getRow(j).getCell(0).getStringCellValue();
						if(s1.equals(s2))
						{
							System.out.println("Repeated Retail Item : "+s2);break;
						}
						else
						{
						}
					}
				}
			}
			
			XSSFSheet sheet6 = wb.getSheet("Modifier");
			int rowCount6 = sheet6.getLastRowNum();
			for(int i = 1; i <= rowCount6; i++)
			{
				String s1 = sheet6.getRow(i).getCell(0).getStringCellValue();
				
				for(int j = 1; j <= rowCount6; j++)
				{
					
					if(i == j)
					{}
					else
					{String s2 = sheet6.getRow(j).getCell(0).getStringCellValue();
						if(s1.equals(s2))
						{
							System.out.println("Repeated Modifier : "+s2);
							System.out.println("Row Number : ");break;
						}
						else
						{
						}
					}

				}
			}
			Thread.sleep(3000);				
			FileOutputStream fout = new FileOutputStream(src);
			
			wb.write(fout);
			
			wb.close();
		
	}

}
