package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browsersSetup.Base;
import page.ForgottenPasswordPage;
import page.LoginPage;
import utils.Utility;

public class VerifyForgottenPasswordPage extends Base
{
	WebDriver driver;
	LoginPage loginPage;
	ForgottenPasswordPage forgottenPasswordPage;
	String testCaseID;
	
	@BeforeSuite()
	public void beforeSuite()
	{
		System.out.println("BEFORE SUITE");
	}
	
	@Parameters("browser")
	@BeforeTest()
	public void openBrowser(String browserName)
	{
		System.out.println("BEFORE TEST");
		System.out.println("BEFORE TEST");
		if(browserName.equals("Chrome"))
		{
			driver = openChromeBrowser();
		}
		if(browserName.equals("Edge"))
		{
			driver = openEdgeBrowser();
		}
		if(browserName.equals("Firefox"))
		{
			driver = openFirefoxBrowser();
		}
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void createPomObject()
	{
		System.out.println("BeforeClass");
		loginPage = new LoginPage(driver);
		forgottenPasswordPage = new ForgottenPasswordPage(driver);
	}
	
	@BeforeMethod
	public void goToForgottenPasswordPage() throws InterruptedException
	{
		driver.get("https://www.facebook.com/");
		loginPage.clickForgotPasswordButton();
		Thread.sleep(4000);
	}
	
	@Test(priority = 0)
	public void verifyForgottenPasswordPageTitleMessage()
	{
		testCaseID = "T200";
		String actualTitleMessage = forgottenPasswordPage.getTitleMessage();
		System.out.println(actualTitleMessage);
		String actualSubTitleMessage = forgottenPasswordPage.getSubTitleMessage();
		System.out.println(actualSubTitleMessage);
		String expectedTitleMessage = "Find Your Account";
		String expectedSubTitleMessage = "Please enter your email address or mobile number to search for your account.";
		Assert.assertEquals(actualTitleMessage, expectedTitleMessage,"Title is wrong");
		Assert.assertEquals(actualSubTitleMessage, expectedSubTitleMessage, "SubTitle is wrong");
//		if(actualTitleMessage.equals(expectedTitleMessage) && actualSubTitleMessage.equals(expectedSubTitleMessage))
//		{
//			System.out.println("PASSED1");
//		}
//		else
//		{
//			System.out.println("FAILED1");
//		}
	}
	
	@Test(priority = 1)
	public void verifyCancelButton() throws InterruptedException
	{
		testCaseID = "T201";
		forgottenPasswordPage.clickOnCancelButton();
		Thread.sleep(4000);
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://www.facebook.com/login.php";
		Assert.assertEquals(actualURL, expectedURL,"URL is wrong");
//		if(actualURL.equals(expectedURL))
//		{
//			System.out.println("PASSED2");
//		}                                               
//		else
//		{
//			System.out.println("FAILED2");
//		}
	}
	
	@Test(priority = 2)
	public void verifySearcButton() throws InterruptedException
	{
		testCaseID = "T202";
		forgottenPasswordPage.ClickOnSearchButton();
		Thread.sleep(4000);
		String s = forgottenPasswordPage.getErrorMessage();
		System.out.println(s);
		System.out.println();
		String actualErrorMessage = s.substring(0, 26);
		System.out.println(actualErrorMessage);
		
		String s1 = "Please fill in at least one field Fill in at least one field to search for your account";
		String expectedErrorMessage = s1.substring(0, 26);
		System.out.println(expectedErrorMessage);
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message is wrong");
//		if(actualErrorMessage.equals(expectedErrorMessage))
//		{
//			System.out.println("PASSED3");
//		}
//		else
//		{
//			System.out.println("FAILED3");
//		}
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		System.out.println("AFTERMETHOD");
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenshot(driver, testCaseID);
		}
	}
	
	@AfterClass
	public void clearObjects()
	{
		System.out.println("AFTERCLASS");
		loginPage = null;
		forgottenPasswordPage = null;
	}
	
	@AfterTest()
	public void closeBrowser()
	{
		System.out.println("AFTER TEST");
		driver.close();
		driver = null;
		System.gc();
	}
	
	@AfterSuite()
	public void afterSuite()
	{
		System.out.println("AFTER SUITE");
	}
	

}
