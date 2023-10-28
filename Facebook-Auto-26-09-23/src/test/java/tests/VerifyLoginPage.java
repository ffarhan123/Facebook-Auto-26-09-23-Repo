package tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
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
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import browsersSetup.Base;
import page.BlankEmailPasswordPage;
import page.BlankPasswordPage;
import page.LoggedInHomePage;
import page.LoginPage;
import utils.Utility;

public class VerifyLoginPage extends Base
{
	LoginPage loginPage;
	BlankPasswordPage blankPasswordPage;
	BlankEmailPasswordPage blankEmailPasswordPage;
	LoggedInHomePage loggedInHomePage;
	WebDriver driver;
	SoftAssert soft;
	String testCaseID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("BEFORE SUITE");
	}
	
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browserName)
	{
		reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}
	
	@BeforeClass
	public void createPomObject()
	{
		System.out.println("BeforeClass");
		loginPage = new LoginPage(driver);
		blankPasswordPage = new BlankPasswordPage(driver);
		blankEmailPasswordPage = new BlankEmailPasswordPage(driver);
		loggedInHomePage = new LoggedInHomePage(driver);
	}
	@BeforeMethod()
	public void goToLoginPage()
	{
		System.out.println("BeforeMethod");
		driver.get("https://www.facebook.com/");
		soft = new SoftAssert();
		
	}
	@Test(priority = 0)
	public void verifyTheLoginButtonByPassingCorrectEmailOnly() throws IOException, InterruptedException
	{
		testCaseID = "T100";
		//String data = Utility.getExcelData("Facebook", 2, 0);
		//Thread.sleep(2000);
		//loginPage.sendUserName(data);
		loginPage.sendUserName("farhanfaisal3963@gmail.com");
		//loginPage.sendPassword();
		loginPage.clickLoginButton();
		String actualTitleMessage = blankPasswordPage.getBlankPasswordErrorTitle();
		String expectedTitledMessage = "Use your Google account";
		String actualMessage = blankPasswordPage.getErrorMessage();
		String expectedMessage = "Quickly log in with your Google account.";
	    soft.assertEquals(actualTitleMessage, expectedTitledMessage, "TitleMessage is wrong");
	    soft.assertEquals(actualMessage, expectedMessage, "Message is Wrong");
	    soft.assertAll();
		
	 }
	@Test(priority = 1)
	public void verifyTheLoginButtonByPassingBlankEmailPassword()
	{
		testCaseID = "T101";
		loginPage.clickLoginButton();
		String actualErrorMessage = blankEmailPasswordPage.getErrorMessage();
		String expectedErrorMessage = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		String actualCurrentURL = driver.getTitle();
		String expectedCurrentURL = "Log in to Facebook";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
		soft.assertEquals(actualCurrentURL, expectedCurrentURL, "Wrong URL");
		//soft.fail();
		soft.assertAll();
	 }
	@Test(priority = 2)
	public void verifyTheLoginButtonByPassingCorrectEmailPassword() throws InterruptedException
	{
		testCaseID = "T102";
		loginPage.sendUserName("farhanfaisal3963@gmail.com");
		loginPage.sendPassword("Microsoft123@");
		loginPage.clickLoginButton();
		Thread.sleep(2000);
		//Thread.sleep(1000);  //instead of 2secs we can try with 1sec also
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://www.facebook.com/";
		boolean result = actualURL.equals(expectedURL);
		System.out.println(result);
		
		loggedInHomePage.clickOnAccountLogo();
		loggedInHomePage.clickOnLoggedOutButton();
		Thread.sleep(5000);
		//loginPage = new LoginPage(driver);   //i tried using object once again here;now just commented it.
		//Thread.sleep(3000);
		String actualTitle = driver.getTitle();
		String expectedTitle = "Facebook – log in or sign up";
		Assert.assertTrue(result);
		soft.assertEquals(actualTitle, expectedTitle);
		soft.assertAll();
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
		System.out.println("AfterClass");
		loginPage = null;
		blankPasswordPage = null;
		blankEmailPasswordPage = null;
		loggedInHomePage = null;
	}
	@AfterTest
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
