package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import module.SignUpPopUp;
import page.LoginPage;

public class Test1 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Documents\\Automation selenium\\V-116\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.get("https://www.facebook.com/");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.sendUserName("farhan");
		loginPage.sendPassword("123657");
		loginPage.clickOnCreateAccountButton();
		
		SignUpPopUp signUpPopUp = new SignUpPopUp(driver);
		signUpPopUp.sendFirstName();
		signUpPopUp.sendLastName();
		signUpPopUp.sendMobileNumberOrEmail();
		signUpPopUp.sendNewPassword();
		signUpPopUp.clickOnDateOfBirth();
		signUpPopUp.clickOnMonthOfBirth();
		signUpPopUp.clickOnYearOfBirth();
		signUpPopUp.clickOnMaleOfGender();
		signUpPopUp.clickOnCustomOfGender();
		signUpPopUp.getSignUpMessage();
		
		
	}

}
