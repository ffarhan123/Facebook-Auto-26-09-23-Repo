package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy(xpath = "//input[@id='email']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@id='pass']")
	private WebElement password;
	
	@FindBy(xpath = "//button[text()='Log in']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//form//div[3]")
	private WebElement forgotPasswordButton;
	
	@FindBy(xpath = "//a[contains(@class,'_42ft _4jy0 _6lti _4jy6 _4jy2 select')]")
	private WebElement createAccountButton;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendUserName(String user)
	{
		userName.sendKeys(user);
	}
	public void sendPassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void clickLoginButton()
	{
		loginButton.click();
	}
	public void clickForgotPasswordButton()
	{
		forgotPasswordButton.click();
	}
	public void clickOnCreateAccountButton()
	{
		createAccountButton.click();
	}
}

