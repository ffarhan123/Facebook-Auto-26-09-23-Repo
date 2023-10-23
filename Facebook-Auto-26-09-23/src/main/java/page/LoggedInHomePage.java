package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoggedInHomePage 
{
	private WebDriver driver;
	private WebDriverWait wait;
	//private Actions action;
	
	@FindBy(xpath = "(//div[contains(@class,'x1rg5ohu x1n2onr6 x3ajldb')])[1]")
	private WebElement AccountLogo;
	
	@FindBy(xpath = "//span[text()='Log Out']")
	private WebElement LoggedOutButton;
	
	public LoggedInHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
		//action = new Actions(driver);
	}
	 
	public void clickOnAccountLogo()
	{
		//WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.elementToBeClickable(AccountLogo));
		AccountLogo.click();
//	    action.moveToElement(AccountLogo).perform();
//	    action.click().perform();
	}
	public void clickOnLoggedOutButton() throws InterruptedException
	{
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(LoggedOutButton));
//		action.moveToElement(LoggedOutButton).perform();
//		action.click().perform();
		//Thread.sleep(3000);
		LoggedOutButton.click();
	}

}

