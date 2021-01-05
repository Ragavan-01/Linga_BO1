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

public class LayAway {

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
	@Test(priority=1)
	public void CreateLayaway() throws InterruptedException
	{
		d.get("http://mystore.lingapos.com/#/store/59fc545908811a719d95912a/layAwaySettings");
		Thread.sleep(3000);
		d.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div/div/div[2]/div[2]/div/div/div[2]/form/div[1]/div/input")).click();
		Thread.sleep(2000);
		Select MinDeposit = new Select(d.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div/div/div[2]/div[2]/div/div/div[2]/form/div[2]/div/select")));
		MinDeposit.selectByVisibleText("Percentage");
		d.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div/div/div[2]/div[2]/div/div/div[2]/form/div[3]/span/input")).clear();
		d.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div/div/div[2]/div[2]/div/div/div[2]/form/div[3]/span/input")).sendKeys("10.00");
		Thread.sleep(2000);
		Select CancelCharge = new Select(d.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div/div/div[2]/div[2]/div/div/div[2]/form/div[4]/div/select")));
		CancelCharge.selectByVisibleText("Percentage");
		d.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div/div/div[2]/div[2]/div/div/div[2]/form/div[5]/span/input")).clear();
		d.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div/div/div[2]/div[2]/div/div/div[2]/form/div[5]/span/input")).sendKeys("10.00");
		Thread.sleep(3000);
		d.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div/div/div[2]/div[2]/div/div/div[2]/form/div[6]/div/div[2]/input[1]")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath("//span[.='Update']")).click();
		Thread.sleep(3000);
		if(d.findElement(By.xpath("//span[.='Lay Away Settings updated successfully']")).getText().equalsIgnoreCase("Lay Away Settings updated successfully"))
		{
			System.out.println("Pass:Lay Away Settings saved successfully");
		}else
		{
			System.out.println("Falied: Could not save Lay away");
		}
	}
	@Test(priority=2)
	public void editLayaway() throws InterruptedException
	{
		d.get("http://mystore.lingapos.com/#/store/59fc545908811a719d95912a/layAwaySettings");
		Thread.sleep(3000);
		//d.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div/div/div[2]/div[2]/div/div/div[2]/form/div[1]/div/input")).click();
		//Thread.sleep(2000);
		Select MinDeposit = new Select(d.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div/div/div[2]/div[2]/div/div/div[2]/form/div[2]/div/select")));
		MinDeposit.selectByVisibleText("Amount");
		d.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div/div/div[2]/div[2]/div/div/div[2]/form/div[3]/span/input")).clear();
		d.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div/div/div[2]/div[2]/div/div/div[2]/form/div[3]/span/input")).sendKeys("20.00");
		Thread.sleep(2000);
		Select CancelCharge = new Select(d.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div/div/div[2]/div[2]/div/div/div[2]/form/div[4]/div/select")));
		CancelCharge.selectByVisibleText("Amount");
		d.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div/div/div[2]/div[2]/div/div/div[2]/form/div[5]/span/input")).clear();
		d.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div/div/div[2]/div[2]/div/div/div[2]/form/div[5]/span/input")).sendKeys("20.00");
		Thread.sleep(3000);
		d.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div/div/div[2]/div[2]/div/div/div[2]/form/div[6]/div/div[2]/input[2]")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath("//span[.='Update']")).click();
		Thread.sleep(3000);
		if(d.findElement(By.xpath("//span[.='Lay Away Settings updated successfully']")).getText().equalsIgnoreCase("Lay Away Settings updated successfully"))
		{
			System.out.println("Pass:Lay Away Settings updated successfully");
		}else
		{
			System.out.println("Falied: Could not Update Lay away");
		}
	}
	@Test(priority=3)
	public void disableLayaway() throws InterruptedException
	{
		d.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div/div/div[2]/div[2]/div/div/div[2]/form/div[1]/div/input")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//span[.='Update']")).click();
		Thread.sleep(3000);
		if(d.findElement(By.xpath("//span[.='Lay Away Settings updated successfully']")).getText().equalsIgnoreCase("Lay Away Settings updated successfully"))
		{
			System.out.println("Pass:Lay Away Settings saved successfully");
		}else
		{
			System.out.println("Falied: Could not save Lay away");
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
