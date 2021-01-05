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

public class Finding_Duplicate_Dept_Cat_SubCat_Mod_Menu_Retail_Teapico_Launge {

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
	
	@Test(priority=1,enabled=false)
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
		
	@Test(priority=500,enabled=false)
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

	@Test(priority=2)
	public void Diff_In_Teapioca_Lounge_7() throws Exception
	{
			System.out.println("Store : 7");
			System.out.println("Store Id : 58615674d5ceb77c75fb44b3");
			File src = new File("C:\\Users\\hariprasanth_j\\Downloads\\Teapioca Lounge #7's Menu WB.xlsx");
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
		System.out.println("---------++++++++++++++++++++++++++++-------------");
	}
	
	@Test(priority=3)
	public void Diff_In_104() throws Exception
	{
		System.out.println("Store : 104");
			System.out.println("Store Id : 5a1df66e08811a413196706e");
			File src = new File("C:\\Users\\hariprasanth_j\\Downloads\\Teapioca Lounge #104's Menu WB.xlsx");
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
			System.out.println("---------++++++++++++++++++++++++++++-------------");
	}
	
	@Test(priority=4)
	public void Diff_In_101() throws Exception
	{
		System.out.println("Store : 101");
			System.out.println("Store Id : 5a3b32a1d5ceb770e77019db");
			File src = new File("C:\\Users\\hariprasanth_j\\Downloads\\Teapioca Lounge #101's Menu WB.xlsx");
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
			System.out.println("---------++++++++++++++++++++++++++++-------------");
	}
	
	@Test(priority=5)
	public void Diff_In_1() throws Exception
	{System.out.println("Store : 1");
			System.out.println("Store Id : 5a47c2a408811a3e1e0a1642");
			File src = new File("C:\\Users\\hariprasanth_j\\Downloads\\Teapioca Lounge #1's Menu WB.xlsx");
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
			System.out.println("---------++++++++++++++++++++++++++++-------------");
	}
	
	@Test(priority=6)
	public void Diff_In_2() throws Exception
	{System.out.println("Store : 2");
			System.out.println("Store Id : 5a47c5f5d5ceb7716dab34c6");
			File src = new File("C:\\Users\\hariprasanth_j\\Downloads\\Teapioca Lounge #2's Menu WB.xlsx");
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
			System.out.println("---------++++++++++++++++++++++++++++-------------");
	}
	
	@Test(priority=7)
	public void Diff_In_3() throws Exception
	{
		System.out.println("Store : 3");
			System.out.println("Store Id : 5a47c6bbd5ceb7716dab385f");
			File src = new File("C:\\Users\\hariprasanth_j\\Downloads\\Teapioca Lounge #3's Menu WB.xlsx");
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
			System.out.println("---------++++++++++++++++++++++++++++-------------");
	}
	
	@Test(priority=8)
	public void Diff_In_102() throws Exception
	{System.out.println("Store : 102");
			System.out.println("Store Id : 5a47ca25d5ceb7716dab3d60");
			File src = new File("C:\\Users\\hariprasanth_j\\Downloads\\Teapioca Lounge #102's Menu WB.xlsx");
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
			System.out.println("---------++++++++++++++++++++++++++++-------------");
	}
	
	@Test(priority=9)
	public void Diff_In_107() throws Exception
	{System.out.println("Store : 107");
			System.out.println("Store Id : 5aca31a9d5ceb7288a8fe160");
			File src = new File("C:\\Users\\hariprasanth_j\\Downloads\\Teapioca Lounge #107's Menu WB.xlsx");
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
			System.out.println("---------++++++++++++++++++++++++++++-------------");
	}
	
	@Test(priority=10)
	public void Diff_In_106() throws Exception
	{System.out.println("Store : 106");
			System.out.println("Store Id : 5aca363808811a691077373a");
			File src = new File("C:\\Users\\hariprasanth_j\\Downloads\\Teapioca Lounge #106's Menu WB.xlsx");
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
			System.out.println("---------++++++++++++++++++++++++++++-------------");
	}
	
	@Test(priority=11)
	public void Diff_In_103() throws Exception
	{System.out.println("Store : 103");
			System.out.println("Store Id : 5aca336bd5ceb7288a8fe5f3");
			File src = new File("C:\\Users\\hariprasanth_j\\Downloads\\Teapioca Lounge #103's Menu WB.xlsx");
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
			System.out.println("---------++++++++++++++++++++++++++++-------------");
	}
	
	@Test(priority=12)
	public void Diff_In_105() throws Exception
	{
		System.out.println("Store : 105");
			System.out.println("Store Id : 5aca383c08811a6910773bc3");
			File src = new File("C:\\Users\\hariprasanth_j\\Downloads\\Teapioca Lounge #105's Menu WB.xlsx");
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
			System.out.println("---------++++++++++++++++++++++++++++-------------");
	}
	
	@Test(priority=13)
	public void Diff_In_6() throws Exception
	{			System.out.println("Store : 6");
			System.out.println("Store Id : 5a1f6e0608811a413196f8c4");
			File src = new File("C:\\Users\\hariprasanth_j\\Downloads\\Teapioca Lounge #6's Menu WB.xlsx");
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
			System.out.println("---------++++++++++++++++++++++++++++-------------");
	}
	
	@Test(priority=14)
	public void Diff_In_Test() throws Exception
	{System.out.println("Store : Test");
			System.out.println("Store Id : 5ba8895acc28f3000121f878");
			File src = new File("C:\\Users\\hariprasanth_j\\Downloads\\Teapioca copy test's Menu WB.xlsx");
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
			System.out.println("---------++++++++++++++++++++++++++++-------------");
	}
	
	@Test(priority=15)
	public void Diff_In_8() throws Exception
	{System.out.println("Store : 8");
			System.out.println("Store Id : 5c1fbbef963c7619df3e10b8");
			File src = new File("C:\\Users\\hariprasanth_j\\Downloads\\Teapioca Lounge #8's Menu WB.xlsx");
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
			System.out.println("---------++++++++++++++++++++++++++++-------------");
	}

}
