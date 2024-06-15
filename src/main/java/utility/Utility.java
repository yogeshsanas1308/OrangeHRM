package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static void  getScreenShotCode(WebDriver driver) throws IOException
	{
		
        File Source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        
        File Dest = new File("D:\\Job\\Screenshot\\orange4.jpg");
        
        FileHandler.copy(Source, Dest);
		
	}
	
	
	
	
}
