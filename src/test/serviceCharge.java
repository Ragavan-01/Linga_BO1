package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class serviceCharge {
	WebDriver d;
	@BeforeClass(description="Launching chrome browser")
	//Launch browser and Log in to store
	public void login() throws Exception
	{
		//Set property to chrome browser
		System.setProperty("webdriver.chrome.driver", Utility.getProperty("Chrome_Driver_Path"));
		//Launch chrome driver
		d = new ChromeDriver();
		//Launch URL
		d.get("http://www.lingapos.com/signin/");
		//Maximize window
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Entering User name
		d.findElement(By.name("txtusername")).sendKeys("hariteststore@mail.com");
		//Entering Password
		d.findElement(By.name("txtpassword")).sendKeys("haristore1");
		//Log in to store
		d.findElement(By.name("submitlogin")).sendKeys(Keys.ENTER);
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Validating whether logged into store by checking Live Updates 
		if(d.findElement(By.xpath("//*[@id=\"navigation\"]/ul[1]/li/a")).getText().equalsIgnoreCase("Sale Dashboard"))
		{
			System.out.println("Log in successful");
		}
		else
		{
			System.out.println("log in unsuccessful");
		}
	}
	//Creating Service charges 
	//Creating Visa service charge
			@Test(priority=1)
			public void createvisaservicecharge() throws InterruptedException
			{
				//URL for Service Charge
				d.get("http://mystore.lingapos.com/#/store/59fc545908811a719d95912a/serviceCharge");
				Thread.sleep(3000);
				
				//Click the Add new Service Charge button
				d.findElement(By.xpath("//button[contains(.,'Service Charge')]")).click();
				Thread.sleep(2000);
				
				//Using the Select class to select the CardType
				Select cardType = new Select(d.findElement(By.name("cardType")));
				cardType.selectByVisibleText("Visa");
				
				//Clear the Service Charge field
				d.findElement(By.name("serviceCharge")).clear();
				//Enter the Service Charge value
				d.findElement(By.name("serviceCharge")).sendKeys("3.00");
				//d.findElement(By.name("tipCharge")).sendKeys("3.00");
				
				Thread.sleep(2000);
				d.findElement(By.xpath("//span[contains(.,'Save')]")).click();
				
				Thread.sleep(3000);
				if(d.findElement(By.xpath("//span[.='Service Charge Added Successfully']")).getText().equalsIgnoreCase("Service Charge Added Successfully"))
				{
					System.out.println("Pass:Visa Service Charges Added Successfully");
				}else
				{
					System.out.println("Falied: Could not Add Visa Service Charge");
				}
			}
		@Test(priority=2)
		public void createmasterservicecharge() throws InterruptedException
		{
			
			d.findElement(By.xpath("//button[contains(.,'Service Charge')]")).click();
			Thread.sleep(2000);
			Select cardType = new Select(d.findElement(By.name("cardType")));
			cardType.selectByVisibleText("Master");
			d.findElement(By.name("serviceCharge")).sendKeys("3.00");
			//d.findElement(By.name("tipCharge")).sendKeys("3.00");
			Thread.sleep(2000);
			d.findElement(By.xpath("//span[contains(.,'Save')]")).click();
			Thread.sleep(3000);
			if(d.findElement(By.xpath("//span[.='Service Charge Added Successfully']")).getText().equalsIgnoreCase("Service Charge Added Successfully"))
			{
				System.out.println("Pass:Master Service Charges Added Successfully");
			}else
			{
				System.out.println("Falied: Could not Add Master Service Charge");
			}
		}
		@Test(priority=3)
		public void createamexservicecharge() throws InterruptedException
		{
			
			d.findElement(By.xpath("//button[contains(.,'Service Charge')]")).click();
			Thread.sleep(2000);
			Select cardType = new Select(d.findElement(By.name("cardType")));
			cardType.selectByVisibleText("Amex");
			d.findElement(By.name("serviceCharge")).sendKeys("3.00");
			//d.findElement(By.name("tipCharge")).sendKeys("3.00");
			Thread.sleep(2000);
			d.findElement(By.xpath("//span[contains(.,'Save')]")).click();
			Thread.sleep(3000);
			if(d.findElement(By.xpath("//span[.='Service Charge Added Successfully']")).getText().equalsIgnoreCase("Service Charge Added Successfully"))
			{
				System.out.println("Pass:Amex Service Charges Added Successfully");
			}else
			{
				System.out.println("Falied: Could not Add Amex Service Charge");
			}
		}
		@Test(priority=4)
		public void createdinersservicecharge() throws InterruptedException
		{
		
			d.findElement(By.xpath("//button[contains(.,'Service Charge')]")).click();
			Thread.sleep(2000);
			Select cardType = new Select(d.findElement(By.name("cardType")));
			cardType.selectByVisibleText("Diners");
			d.findElement(By.name("serviceCharge")).sendKeys("3.00");
			//d.findElement(By.name("tipCharge")).sendKeys("3.00");
			Thread.sleep(2000);
			d.findElement(By.xpath("//span[contains(.,'Save')]")).click();
			Thread.sleep(3000);
			if(d.findElement(By.xpath("//span[.='Service Charge Added Successfully']")).getText().equalsIgnoreCase("Service Charge Added Successfully"))
			{
				System.out.println("Pass:Diners Service Charges Added Successfully");
			}else
			{
				System.out.println("Falied: Could not Add Diners Service Charge");
			}
		}
		@Test(priority=5)
		public void createjcbservicecharge() throws InterruptedException
		{
		
			d.findElement(By.xpath("//button[contains(.,'Service Charge')]")).click();
			Thread.sleep(2000);
			Select cardType = new Select(d.findElement(By.name("cardType")));
			cardType.selectByVisibleText("JCB");
			d.findElement(By.name("serviceCharge")).sendKeys("3.00");
			//d.findElement(By.name("tipCharge")).sendKeys("3.00");
			Thread.sleep(2000);
			d.findElement(By.xpath("//span[contains(.,'Save')]")).click();
			Thread.sleep(3000);
			if(d.findElement(By.xpath("//span[.='Service Charge Added Successfully']")).getText().equalsIgnoreCase("Service Charge Added Successfully"))
			{
				System.out.println("Pass:JCB Service Charges Added Successfully");
			}else
			{
				System.out.println("Falied: Could not Add JCB Service Charge");
			}
		}
		@Test(priority=6)
		public void creatediscoverservicecharge() throws InterruptedException
		{
			
			d.findElement(By.xpath("//button[contains(.,'Service Charge')]")).click();
			Thread.sleep(2000);
			Select cardType = new Select(d.findElement(By.name("cardType")));
			cardType.selectByVisibleText("Discover");
			d.findElement(By.name("serviceCharge")).sendKeys("3.00");
			//d.findElement(By.name("tipCharge")).sendKeys("3.00");
			Thread.sleep(2000);
			d.findElement(By.xpath("//span[contains(.,'Save')]")).click();
			Thread.sleep(3000);
			if(d.findElement(By.xpath("//span[.='Service Charge Added Successfully']")).getText().equalsIgnoreCase("Service Charge Added Successfully"))
			{
				System.out.println("Pass:Discover Service Charges Added Successfully");
			}else
			{
				System.out.println("Falied: Could not Add Discover Service Charge");
			}
		}
		@Test(priority=7)
		public void createothersservicecharge() throws InterruptedException
		{
			d.findElement(By.xpath("//button[contains(.,'Service Charge')]")).click();
			Thread.sleep(2000);
			Select cardType = new Select(d.findElement(By.name("cardType")));
			cardType.selectByVisibleText("Others");
			d.findElement(By.name("serviceCharge")).sendKeys("3.00");
			//d.findElement(By.name("tipCharge")).sendKeys("3.00");
			Thread.sleep(2000);
			d.findElement(By.xpath("//span[contains(.,'Save')]")).click();
			Thread.sleep(3000);
			if(d.findElement(By.xpath("//span[.='Service Charge Added Successfully']")).getText().equalsIgnoreCase("Service Charge Added Successfully"))
			{
				System.out.println("Pass:Others Service Charges Added Successfully");
			}else
			{
				System.out.println("Falied: Could not Add Others Service Charge");
			}
		}
		//Trying to create service which is already created
		@Test(priority=8)
		public void createagainvisaservicecharge() throws InterruptedException
		{
			
			Thread.sleep(3000);
			d.findElement(By.xpath("//button[contains(.,'Service Charge')]")).click();
			Thread.sleep(2000);
			Select cardType = new Select(d.findElement(By.name("cardType")));
			cardType.selectByVisibleText("Visa");
			d.findElement(By.name("serviceCharge")).sendKeys("3.00");
			//d.findElement(By.name("tipCharge")).sendKeys("3.00");
			Thread.sleep(2000);
			d.findElement(By.xpath("//span[contains(.,'Save')]")).click();
			Thread.sleep(3000);
			if(d.findElement(By.xpath("//span[.='Card Visa is already Used.']")).getText().equalsIgnoreCase("Card Visa is already Used."))
			{
				System.out.println("Pass:Visa Service Charges Already exists");
			}else
			{
				System.out.println("Falied: Visa SC added");
			}
			d.findElement(By.xpath("//a[.='Close']")).click();
		}
		@Test(priority=9)
		public void createagainmasterservicecharge() throws InterruptedException
		{
			
			d.findElement(By.xpath("//button[contains(.,'Service Charge')]")).click();
			Thread.sleep(2000);
			Select cardType = new Select(d.findElement(By.name("cardType")));
			cardType.selectByVisibleText("Master");
			d.findElement(By.name("serviceCharge")).sendKeys("3.00");
			//d.findElement(By.name("tipCharge")).sendKeys("3.00");
			Thread.sleep(2000);
			d.findElement(By.xpath("//span[contains(.,'Save')]")).click();
			Thread.sleep(3000);
			if(d.findElement(By.xpath("//span[.='Card Master is already Used.']")).getText().equalsIgnoreCase("Card Master is already Used."))
			{
				System.out.println("Pass:Master Service Charges Already exists");
			}else
			{
				System.out.println("Falied: Master SC added");
			}
			d.findElement(By.xpath("//a[.='Close']")).click();
		}
		@Test(priority=10)
		public void createagainamexservicecharge() throws InterruptedException
		{
			
			d.findElement(By.xpath("//button[contains(.,'Service Charge')]")).click();
			Thread.sleep(2000);
			Select cardType = new Select(d.findElement(By.name("cardType")));
			cardType.selectByVisibleText("Amex");
			d.findElement(By.name("serviceCharge")).sendKeys("3.00");
			//d.findElement(By.name("tipCharge")).sendKeys("3.00");
			Thread.sleep(2000);
			d.findElement(By.xpath("//span[contains(.,'Save')]")).click();
			Thread.sleep(3000);
			if(d.findElement(By.xpath("//span[.='Card Amex is already Used.']")).getText().equalsIgnoreCase("Card Amex is already Used."))
			{
				System.out.println("Pass:Amex Service Charges Already exists");
			}else
			{
				System.out.println("Falied: Amex SC added");
			}
			d.findElement(By.xpath("//a[.='Close']")).click();
		}
		@Test(priority=11)
		public void createagaindinersservicecharge() throws InterruptedException
		{
		
			d.findElement(By.xpath("//button[contains(.,'Service Charge')]")).click();
			Thread.sleep(2000);
			Select cardType = new Select(d.findElement(By.name("cardType")));
			cardType.selectByVisibleText("Diners");
			d.findElement(By.name("serviceCharge")).sendKeys("3.00");
			//d.findElement(By.name("tipCharge")).sendKeys("3.00");
			Thread.sleep(2000);
			d.findElement(By.xpath("//span[contains(.,'Save')]")).click();
			Thread.sleep(3000);
			if(d.findElement(By.xpath("//span[.='Card Diners is already Used.']")).getText().equalsIgnoreCase("Card Diners is already Used."))
			{
				System.out.println("Pass:Diners Service Charges Already exists");
			}else
			{
				System.out.println("Falied: Diners SC added");
			}
			d.findElement(By.xpath("//a[.='Close']")).click();
		}
		@Test(priority=12)
		public void createagainjcbservicecharge() throws InterruptedException
		{
		
			d.findElement(By.xpath("//button[contains(.,'Service Charge')]")).click();
			Thread.sleep(2000);
			Select cardType = new Select(d.findElement(By.name("cardType")));
			cardType.selectByVisibleText("JCB");
			d.findElement(By.name("serviceCharge")).sendKeys("3.00");
			//d.findElement(By.name("tipCharge")).sendKeys("3.00");
			Thread.sleep(2000);
			d.findElement(By.xpath("//span[contains(.,'Save')]")).click();
			Thread.sleep(3000);
			if(d.findElement(By.xpath("//span[.='Card JCB is already Used.']")).getText().equalsIgnoreCase("Card JCB is already Used."))
			{
				System.out.println("Pass:JCB Service Charges Already exists");
			}else
			{
				System.out.println("Falied: JCB SC Added");
			}
			d.findElement(By.xpath("//a[.='Close']")).click();
		}
		@Test(priority=13)
		public void createagaindiscoverservicecharge() throws InterruptedException
		{
			
			d.findElement(By.xpath("//button[contains(.,'Service Charge')]")).click();
			Thread.sleep(2000);
			Select cardType = new Select(d.findElement(By.name("cardType")));
			cardType.selectByVisibleText("Discover");
			d.findElement(By.name("serviceCharge")).sendKeys("3.00");
			//d.findElement(By.name("tipCharge")).sendKeys("3.00");
			Thread.sleep(2000);
			d.findElement(By.xpath("//span[contains(.,'Save')]")).click();
			Thread.sleep(3000);
			if(d.findElement(By.xpath("//span[.='Card Discover is already Used.']")).getText().equalsIgnoreCase("Card Discover is already Used."))
			{
				System.out.println("Pass:Discover Service Charges Already exists");
			}else
			{
				System.out.println("Falied: Discover SC added");
			}
			d.findElement(By.xpath("//a[.='Close']")).click();
		}
		@Test(priority=14)
		public void createagainothersservicecharge() throws InterruptedException
		{
			d.findElement(By.xpath("//button[contains(.,'Service Charge')]")).click();
			Thread.sleep(2000);
			Select cardType = new Select(d.findElement(By.name("cardType")));
			cardType.selectByVisibleText("Others");
			d.findElement(By.name("serviceCharge")).sendKeys("3.00");
			//d.findElement(By.name("tipCharge")).sendKeys("3.00");
			Thread.sleep(2000);
			d.findElement(By.xpath("//span[contains(.,'Save')]")).click();
			Thread.sleep(3000);
			if(d.findElement(By.xpath("//span[.='Card Others is already Used.']")).getText().equalsIgnoreCase("Card Visa is already Used."))
			{
				System.out.println("Pass:Others Service Charges Already exists");
			}else
			{
				System.out.println("Falied: Others SC added");
			}
			d.findElement(By.xpath("//a[.='Close']")).click();
		}
	//Edit or Update service charge
	@Test(priority=15)
	public void editvisaservicecharge() throws InterruptedException
	{
		d.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		d.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("Visa");
		Thread.sleep(2000);		
		d.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/table/tbody/tr[1]/td[4]/span/a[1]/i")).click();
		Thread.sleep(2000);		
		d.findElement(By.name("serviceCharge")).clear();
		Thread.sleep(2000);		
		d.findElement(By.name("serviceCharge")).sendKeys("3.99");
		Thread.sleep(2000);		
		d.findElement(By.name("tipCharge")).sendKeys("3.99");
		Thread.sleep(2000);		
		d.findElement(By.xpath("//span[contains(.,'Save')]")).click();
		Thread.sleep(3000);
		if(d.findElement(By.xpath("//span[.='Service Charges Updated Successfully']")).getText().equalsIgnoreCase("Service Charges Updated Successfully"))
		{
			System.out.println("Pass:Visa Service Charges updated Successfully");
		}else
		{
			System.out.println("Falied: Could not updated Visa Service Charge");
		}
		
	}
	@Test(priority=16)
	public void editmasterservicecharge() throws InterruptedException
	{
		d.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		d.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("Master");
		Thread.sleep(2000);		
		d.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/table/tbody/tr/td[4]/span/a[1]")).click();d.findElement(By.name("serviceCharge")).sendKeys("3.99");
		d.findElement(By.name("serviceCharge")).clear();
		Thread.sleep(2000);		
		d.findElement(By.name("serviceCharge")).sendKeys("3.99");
		Thread.sleep(2000);		
		d.findElement(By.name("tipCharge")).sendKeys("3.99");
		Thread.sleep(2000);		
		d.findElement(By.xpath("//span[contains(.,'Save')]")).click();
		Thread.sleep(3000);
		if(d.findElement(By.xpath("//span[.='Service Charges Updated Successfully']")).getText().equalsIgnoreCase("Service Charges Updated Successfully"))
		{
			System.out.println("Pass:Master Service Charges updated Successfully");
		}else
		{
			System.out.println("Falied: Could not updated Master Service Charge");
		}
		
	}
	@Test(priority=17)
	public void editamexservicecharge() throws InterruptedException
	{
		d.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		d.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("Amex");
		Thread.sleep(2000);		
		d.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/table/tbody/tr/td[4]/span/a[1]")).click();
		d.findElement(By.name("serviceCharge")).clear();
		Thread.sleep(2000);		
		d.findElement(By.name("serviceCharge")).sendKeys("3.99");
		Thread.sleep(2000);		
		d.findElement(By.name("tipCharge")).sendKeys("3.99");
		Thread.sleep(2000);		
		d.findElement(By.xpath("//span[contains(.,'Save')]")).click();
		Thread.sleep(3000);
		if(d.findElement(By.xpath("//span[.='Service Charges Updated Successfully']")).getText().equalsIgnoreCase("Service Charges Updated Successfully"))
		{
			System.out.println("Pass:Amex Service Charges updated Successfully");
		}else
		{
			System.out.println("Falied: Could not updated Amex Service Charge");
		}
		
	}
	@Test(priority=18)
	public void editdinersservicecharge() throws InterruptedException
	{
		d.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		d.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("Diners");
		Thread.sleep(2000);		
		d.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/table/tbody/tr/td[4]/span/a[1]")).click();d.findElement(By.name("serviceCharge")).sendKeys("3.99");
		d.findElement(By.name("serviceCharge")).clear();
		Thread.sleep(2000);		
		d.findElement(By.name("serviceCharge")).sendKeys("3.99");
		Thread.sleep(2000);		
		d.findElement(By.name("tipCharge")).sendKeys("3.99");
		Thread.sleep(2000);		
		d.findElement(By.xpath("//span[contains(.,'Save')]")).click();
		Thread.sleep(3000);
		if(d.findElement(By.xpath("//span[.='Service Charges Updated Successfully']")).getText().equalsIgnoreCase("Service Charges Updated Successfully"))
		{
			System.out.println("Pass:Diners Service Charges updated Successfully");
		}else
		{
			System.out.println("Falied: Could not updated Diners Service Charge");
		}
		
	}
	@Test(priority=19)
	public void editjcbservicecharge() throws InterruptedException
	{
		d.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		d.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("JCB");
		Thread.sleep(2000);		
		d.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/table/tbody/tr/td[4]/span/a[1]")).click();d.findElement(By.name("serviceCharge")).sendKeys("3.99");
		d.findElement(By.name("serviceCharge")).clear();
		Thread.sleep(2000);		
		d.findElement(By.name("serviceCharge")).sendKeys("3.99");
		Thread.sleep(2000);		
		d.findElement(By.name("tipCharge")).sendKeys("3.99");
		Thread.sleep(2000);		
		d.findElement(By.xpath("//span[contains(.,'Save')]")).click();
		Thread.sleep(3000);
		if(d.findElement(By.xpath("//span[.='Service Charges Updated Successfully']")).getText().equalsIgnoreCase("Service Charges Updated Successfully"))
		{
			System.out.println("Pass:JCB Service Charges updated Successfully");
		}else
		{
			System.out.println("Falied: Could not updated JCB Service Charge");
		}
		
	}
	@Test(priority=20)
	public void editdiscoverservicecharge() throws InterruptedException
	{
		d.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		d.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("Discover");
		Thread.sleep(2000);		
		d.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/table/tbody/tr/td[4]/span/a[1]")).click();d.findElement(By.name("serviceCharge")).sendKeys("3.99");
		d.findElement(By.name("serviceCharge")).clear();
		Thread.sleep(2000);		
		d.findElement(By.name("serviceCharge")).sendKeys("3.99");
		Thread.sleep(2000);		
		d.findElement(By.name("tipCharge")).sendKeys("3.99");
		Thread.sleep(2000);		
		d.findElement(By.xpath("//span[contains(.,'Save')]")).click();
		Thread.sleep(3000);
		if(d.findElement(By.xpath("//span[.='Service Charges Updated Successfully']")).getText().equalsIgnoreCase("Service Charges Updated Successfully"))
		{
			System.out.println("Pass:Discover Service Charges updated Successfully");
		}else
		{
			System.out.println("Falied: Could not updated Discover Service Charge");
		}
		
	}
	@Test(priority=21)
	public void editothersservicecharge() throws InterruptedException
	{
		d.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		d.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("Others");
		Thread.sleep(2000);		
		d.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div/div/div[2]/div[3]/div[1]/div/div/div[2]/div[2]/table/tbody/tr/td[4]/span/a[1]")).click();d.findElement(By.name("serviceCharge")).sendKeys("3.99");
		d.findElement(By.name("serviceCharge")).clear();
		Thread.sleep(2000);		
		d.findElement(By.name("serviceCharge")).sendKeys("3.99");
		Thread.sleep(2000);		
		d.findElement(By.name("tipCharge")).sendKeys("3.99");
		Thread.sleep(2000);		
		d.findElement(By.xpath("//span[contains(.,'Save')]")).click();
		Thread.sleep(3000);
		if(d.findElement(By.xpath("//span[.='Service Charges Updated Successfully']")).getText().equalsIgnoreCase("Service Charges Updated Successfully"))
		{
			System.out.println("Pass:Others Service Charges updated Successfully");
		}else
		{
			System.out.println("Falied: Could not updated Others Service Charge");
		}
		
	}
	//Delete Service Charge
	@Test(priority=22)
	public void deletevisaservicecharge() throws InterruptedException
	{
		d.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		d.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("Visa");
		Thread.sleep(2000);		
		d.findElement(By.xpath("//i[@class='fa fa-pencil']")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath("//*[@id=\"body\"]/div[1]/div/div/div[3]/div/a[2]")).click();
		Thread.sleep(2000);
		if(d.findElement(By.xpath("//span[.='Service Charge Removed successfuly']")).getText().equalsIgnoreCase("Service Charge Removed successfuly"))
		{
			System.out.println("Pass:Visa Service Charges Removed Successfully");
		}else
		{
			System.out.println("Falied: Could not Removed Visa Service Charge");
		}
	}
	@Test(priority=23)
	public void deletemasterservicecharge() throws InterruptedException
	{
		d.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		d.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("Master");
		Thread.sleep(5000);	
		d.findElement(By.xpath("//i[@class='fa fa-pencil']")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath("//*[@id=\"body\"]/div[1]/div/div/div[3]/div/a[2]")).click();
		Thread.sleep(2000);
		if(d.findElement(By.xpath("//span[.='Service Charge Removed successfuly']")).getText().equalsIgnoreCase("Service Charge Removed successfuly"))
		{
			System.out.println("Pass:Master Service Charges Removed Successfully");
		}else
		{
			System.out.println("Falied: Could not Removed Master Service Charge");
		}
	}
	@Test(priority=24)
	public void deleteamexservicecharge() throws InterruptedException
	{
		d.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		d.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("Amex");
		Thread.sleep(5000);	
		d.findElement(By.xpath("//i[@class='fa fa-pencil']")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath("//*[@id=\"body\"]/div[1]/div/div/div[3]/div/a[2]")).click();
		Thread.sleep(2000);
		if(d.findElement(By.xpath("//span[.='Service Charge Removed successfuly']")).getText().equalsIgnoreCase("Service Charge Removed successfuly"))
		{
			System.out.println("Pass:Amex Service Charges Removed Successfully");
		}else
		{
			System.out.println("Falied: Could not Removed Amex Service Charge");
		}
	}
	@Test(priority=25)
	public void deletedinersservicecharge() throws InterruptedException
	{
		d.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		d.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("Diners");
		Thread.sleep(5000);		
		d.findElement(By.xpath("//i[@class='fa fa-pencil']")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath("//*[@id=\"body\"]/div[1]/div/div/div[3]/div/a[2]")).click();
		Thread.sleep(2000);
		if(d.findElement(By.xpath("//span[.='Service Charge Removed successfuly']")).getText().equalsIgnoreCase("Service Charge Removed successfuly"))
		{
			System.out.println("Pass:Diners Service Charges Removed Successfully");
		}else
		{
			System.out.println("Falied: Could not Removed Diners Service Charge");
		}
	}
	@Test(priority=26)
	public void deletejcbservicecharge() throws InterruptedException
	{
		d.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		d.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("JCB");
		Thread.sleep(5000);		
		d.findElement(By.xpath("//i[@class='fa fa-pencil']")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath("//*[@id=\"body\"]/div[1]/div/div/div[3]/div/a[2]")).click();
		Thread.sleep(2000);
		if(d.findElement(By.xpath("//span[.='Service Charge Removed successfuly']")).getText().equalsIgnoreCase("Service Charge Removed successfuly"))
		{
			System.out.println("Pass:JCB Service Charges Removed Successfully");
		}else
		{
			System.out.println("Falied: Could not Removed JCB Service Charge");
		}
	}
	@Test(priority=27)
	public void deletediscoverservicecharge() throws InterruptedException
	{
		d.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		d.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("Discover");
		Thread.sleep(5000);		
		d.findElement(By.xpath("//i[@class='fa fa-pencil']")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath("//*[@id=\"body\"]/div[1]/div/div/div[3]/div/a[2]")).click();
		Thread.sleep(2000);
		if(d.findElement(By.xpath("//span[.='Service Charge Removed successfuly']")).getText().equalsIgnoreCase("Service Charge Removed successfuly"))
		{
			System.out.println("Pass:Discover Service Charges Removed Successfully");
		}else
		{
			System.out.println("Falied: Could not Removed Discover Service Charge");
		}
	}
	@Test(priority=28)
	public void deleteothersservicecharge() throws InterruptedException
	{
		d.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		d.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("Others");
		Thread.sleep(5000);		
		d.findElement(By.xpath("//i[@class='fa fa-pencil']")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath("//*[@id=\"body\"]/div[1]/div/div/div[3]/div/a[2]")).click();
		Thread.sleep(2000);
		if(d.findElement(By.xpath("//span[.='Service Charge Removed successfuly']")).getText().equalsIgnoreCase("Service Charge Removed successfuly"))
		{
			System.out.println("Pass:Others Service Charges Removed Successfully");
		}else
		{
			System.out.println("Falied: Could not Removed Others Service Charge");
		}
	}
	
	
	@AfterClass(description="Closing the browser")
	public void close() throws InterruptedException
	{
		{
			//WebDriver d=new ChromeDriver();
			d.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[1]/div[2]/div/div/div/div[4]/a/i"));
			d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			d.findElement(By.xpath("//div[@id='side-bar']/div/div[1]/div[1]/div[2]/div/div/div/div[4]/a/i")).click();
		    d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(5000);
		    if(d.findElement(By.xpath("//div[@id='x-content-band-1']/div/div[2]/h2")).getText().equalsIgnoreCase("Account Login"))
			{
		    	System.out.println("Logged out Successfully");
			}
			else
			{
				System.out.println("User Logged out Failed");
			}
			Thread.sleep(5000);
			d.close();
			d.quit();
		}

}
}