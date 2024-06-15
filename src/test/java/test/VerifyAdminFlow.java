package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BrowserCode;
import pom.AdminModule;
import pom.HeadersOfOrangeHRM;
import pom.LoginPage;
import utility.Utility;

public class VerifyAdminFlow {
	
	private LoginPage loginPage;
	private HeadersOfOrangeHRM headersOfOrangeHRM;
	private AdminModule adminModule;
	private WebDriver driver;
	private SoftAssert soft;
	private Utility utility;
	
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) throws InterruptedException
	{
        if(browser.equalsIgnoreCase("edge")) {
		
			
			driver=BrowserCode.launchEdgeBrowser();
		}
	
		if(browser.equalsIgnoreCase("chrome")) {
		
	         driver =BrowserCode.launchChromeBrowser(); 
		}
		Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
        driver.manage().window().maximize();
	
	
	
	}

	@BeforeClass
	public void pomObjects()
	{
		
		loginPage = new LoginPage(driver);
		headersOfOrangeHRM = new HeadersOfOrangeHRM(driver);
		adminModule = new AdminModule(driver);
		utility = new Utility();
	}
	
	@BeforeMethod
	public void loginInOrangeHRM() throws Exception
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        
        loginPage.enterCredentialsAndClick("Admin", "admin123");
        
        
	}
	
	@Test
	public void verifyAdminModuleFlow() throws InterruptedException, IOException
	{
		soft = new SoftAssert();
		//verify Title
		String title = driver.getTitle();
		System.out.println("Title of current page = "+title);
		
		soft.assertEquals(title,"OrangeHRM","Title Failed- please check title of currentPage");
		
		String url = driver.getCurrentUrl();
		soft.assertEquals(url,"https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers","URL Failed- please check title of currentPage");
		System.out.println("url of current page = "+url);
		Thread.sleep(3000);
		headersOfOrangeHRM.clickOnAdminModule();
		//adminModule.editSecondRecord();
		
		adminModule.editSecondRecord();
		Thread.sleep(3000);
		adminModule.selectValueFromUserRole();
		Thread.sleep(3000);
		adminModule.clearUserNameInUserManagenent();
		Thread.sleep(3000);
		adminModule.enterUserNameInUserManagenent("jojobean123");
		Thread.sleep(3000);
		Utility.getScreenShotCode(driver);
		
		
		
	}
	
	@AfterMethod
	public void logoutFromOrangeHRM()
	{
		headersOfOrangeHRM.clickOnLogoutButton();
	}
	
	@AfterClass
	public void nullAllPomObjects()
	{
		loginPage = null;
		headersOfOrangeHRM = null;
		adminModule = null;
		soft = null;
		
	}
	@AfterTest
	public void closeBrowser () {
		
		driver.close();
		driver = null ;
		
		System.gc();
	}
	

}
