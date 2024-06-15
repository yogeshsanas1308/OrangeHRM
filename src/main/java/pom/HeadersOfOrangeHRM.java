package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeadersOfOrangeHRM {
	@FindBy (xpath = "//span[text()='Admin']")
	private WebElement adminModule;
	
	@FindBy (xpath ="//input[@class='oxd-input oxd-input--active']")
	private WebElement password;
	
	@FindBy (xpath="//p[contains(@class,'oxd-userdropdown-name')]")
	private WebElement logoutDropdown;
	
	@FindBy (xpath="(//a[contains(@class,'oxd-userdropdown-link')])[4]")
	private WebElement logoutButton;
	
	

	
	WebDriverWait wait;
	Actions actions ;
	
	public HeadersOfOrangeHRM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,10);
		actions = new Actions(driver);
	}
	

	
	public void clickOnAdminModule()
	{
		wait.until(ExpectedConditions.visibilityOf(adminModule));
		adminModule.click();
	}
	public void clickOnLogoutButton()
	{
		logoutDropdown.click();
		logoutButton.click();
		
	}
	

}
