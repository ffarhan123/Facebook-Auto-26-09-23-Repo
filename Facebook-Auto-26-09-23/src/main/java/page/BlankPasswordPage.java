package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlankPasswordPage
{
	@FindBy(xpath = "//h2[@class=\"uiHeaderTitle\"]")
	private WebElement BlankPasswordErrorTitle;
	
	@FindBy(xpath = "(//div[contains(@class,'phl ptm uiInterstitia')]//td[1]//div)[1]")
	private WebElement ErrorMessage;
	
	public BlankPasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getBlankPasswordErrorTitle()
	{
		String text =BlankPasswordErrorTitle.getText();
		return text;
	}
	public String getErrorMessage()
	{
		return ErrorMessage.getText();
	}

}
