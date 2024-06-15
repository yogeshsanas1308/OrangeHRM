package pom;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminModule {
	@FindBy (xpath = "(//i[contains(@class,'oxd-icon bi-pencil-fill')])[2]")
	private WebElement flmName;
	
	@FindBy (xpath ="(//div[contains(@class,'oxd-select-text-input')])[1]")
	private List<WebElement> userRole;
	
	@FindBy (xpath ="(//div[contains(@class,'oxd-select-text-input')])[1]")
	private WebElement userRole1;
	
	@FindBy (xpath ="(//div[@class='oxd-select-option'])[2]")
	private WebElement adminValue;
	
	
	
	@FindBy (xpath="//button[@type='submit']")
	private WebElement submitButton;
	
	@FindBy (xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement userNameInUserManagenent;
	
	@FindBy (xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement userNameInUser;
	

	
	WebDriverWait wait;
	Actions actions ;
	
	public AdminModule(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,10);
		
	}
	
	public void editSecondRecord()
	{
		flmName.click();
	
	}

	public void selectValueFromUserRole()
	{
		userRole1.click();
		adminValue.click();
		
  
	}
	public void clearUserNameInUserManagenent()
	{
		
		userNameInUser.clear();
		
	}
	
	public void enterUserNameInUserManagenent(String userdata)
	{
	
		
		userNameInUserManagenent.sendKeys(userdata);
		
	}
	
	public void clickOnsubmitButton()
	{
		submitButton.click();
	}

}
