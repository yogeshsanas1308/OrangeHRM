package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
;

public class BrowserCode {
	
	public static WebDriver launchEdgeBrowser() {
		System.setProperty("webdriver.edge.driver", "C:\\Automation -Selenium WebDriver/msedgedriver.exe");

        // Initialize WebDriver
       WebDriver  driver = new EdgeDriver();
       return driver;
	}
	
	public static WebDriver launchChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Automation -Selenium WebDriver\\chromedriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
       return driver;
	}

}
