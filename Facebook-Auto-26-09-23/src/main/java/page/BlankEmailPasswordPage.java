package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlankEmailPasswordPage 
{
	@FindBy(xpath ="//div[@id='email_container']//div[2]")
	private WebElement ErrorMessage;
	
	public BlankEmailPasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getErrorMessage()
	{
		return ErrorMessage.getText();
	}
	


}
