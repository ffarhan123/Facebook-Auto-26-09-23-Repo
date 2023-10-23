package module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPopUp 
{
	@FindBy(xpath = "(//div[@class='pvl _52lp _59d-']//div)[1]")
	private WebElement SignUpMessage;
	
	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement FirstName;
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement LastName;
	
	@FindBy(xpath = "//input[@aria-label='Mobile number or email address']")
	private WebElement MobileNumberOrEmail;
	
	@FindBy(xpath = "//input[@aria-label='New password']")
	private WebElement NewPassword;
	
	@FindBy(xpath = "//select[@id='day']")
	private WebElement DateOfBirth;
	
	@FindBy(xpath = "//select[@id='month']")
	private WebElement MonthOfBirth;
	
	@FindBy(xpath = "//select[@id='year']")
	private WebElement YearOfBirth;
	
	@FindBy(xpath = "(//input[@type='radio'])[1]")
	private WebElement FemaleOfGender;
	
	@FindBy(xpath = "(//input[@type='radio'])[2]")
	private WebElement MaleOfGender;
	
	@FindBy(xpath = "(//input[@type='radio'])[3]")
	private WebElement CustomOfGender;
	
	@FindBy(xpath = "(//button[@type='submit'])[2] ")
	private WebElement SignUpButton;
	
	private WebDriver driver;
	private Actions action;
	private Select select;

	public SignUpPopUp(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void sendFirstName()
	{
		FirstName.sendKeys("Ashar");
	}
	public void sendLastName()
	{
		LastName.sendKeys("khan");
	}
	public void sendMobileNumberOrEmail()
	{
		MobileNumberOrEmail.sendKeys("asharkhan1109@gmail.com");
	}
	public void sendNewPassword()
	{
		NewPassword.sendKeys("ashar11230");
	}
	public void clickOnDateOfBirth()
	{
	   select = new Select(DateOfBirth);
	   select.selectByIndex(12);
	}
	public void clickOnMonthOfBirth()
	{
		select = new Select(MonthOfBirth);
		select.selectByValue("1");
	}
	public void clickOnYearOfBirth()
	{
		select = new Select(YearOfBirth);
		select.selectByVisibleText("2023");
	}
	public void clickOnMaleOfGender()
	{
		action = new Actions(driver);
		action.moveToElement(MaleOfGender).click().build().perform();
		//MaleOfGender.click();
	}
	public void clickOnCustomOfGender()
	{
		action = new Actions(driver);
		action.moveToElement(CustomOfGender).click().build().perform();
		CustomOfGender.click();
	}
	public void getSignUpMessage()
	{
		String text = SignUpMessage.getText();
		System.out.println(text);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
