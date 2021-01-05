package templates;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	
   
	public static String captureScreenshot(WebDriver driver,String screenshotName)
	{

		try 
		{
			
			/*File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Calendar calendar = Calendar.getInstance();
			int hour = calendar.get(Calendar.HOUR_OF_DAY);
			int minute = calendar.get(Calendar.MINUTE);

			String directory = "filPath";
			String fileName = "snapshot_"+ hour + "_"+ minute +".png";

			File dest = new File(directory, fileName);
			FileUtils.copyFile(scr, dest);
			Thread.sleep(3000);*/ 
			
			TakesScreenshot ts=(TakesScreenshot)driver;

			File source=ts.getScreenshotAs(OutputType.FILE);


			FileUtils.copyFile(source, new File("res/"+screenshotName+".png"));
			return "res/"+screenshotName+".png";
			
		} 
		catch (Exception e)
		{

			System.out.println("Exception while taking screenshot "+e.getMessage());
			return e.getMessage();
		} 
	}
}
