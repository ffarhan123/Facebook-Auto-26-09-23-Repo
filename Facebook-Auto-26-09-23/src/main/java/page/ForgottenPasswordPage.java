package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgottenPasswordPage 
{
	@FindBy(xpath = "//form[@id='identify_yourself_flow']//div[2]//h2")
	private WebElement TitleMessage;
	
	@FindBy(xpath = "//table//div")
	private WebElement SubTitleMessage;
	
	@FindBy(xpath = "//input[@id='identify_email']")
	private WebElement EmailAddressOrMobileField;
	
	@FindBy(xpath = "//a[text()='Cancel']")
	private WebElement CancelButton;
	
	@FindBy(xpath = "//button[text()='Search']")
	private WebElement SearchButton;
	
	@FindBy(xpath = "(//form[@id='identify_yourself_flow']//div)[8]")
	private WebElement ErrorMessage;
	
	
public ForgottenPasswordPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public String getTitleMessage()
{
	return TitleMessage.getText();
}

public String getSubTitleMessage() 
{
	return SubTitleMessage.getText();
	
}
public void clickOnCancelButton() 
{
	CancelButton.click();
	
}
public void ClickOnSearchButton() 
{
	SearchButton.click();
	
}
public String getErrorMessage() 
{
	return ErrorMessage.getText();
	
}

	
	
	
	

}
