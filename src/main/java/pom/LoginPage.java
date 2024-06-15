package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	@FindBy (xpath = "(//input[contains(@class,'oxd-input oxd-input-')])[1]")
	private WebElement userName;
	
	@FindBy (xpath ="//input[@class='oxd-input oxd-input--active']")
	private WebElement password;
	
	@FindBy (xpath="//button[@type='submit']")
	private WebElement logInButton;
	
	

	
	WebDriverWait wait;
	Actions actions ;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,10);
		actions = new Actions(driver);
	}
	

	
	public void enterCredentialsAndClick(String userId, String pass)
	{
		wait.until(ExpectedConditions.visibilityOf(userName));
		userName.sendKeys(userId);
		password.sendKeys(pass);
		logInButton.click();
	}

}
