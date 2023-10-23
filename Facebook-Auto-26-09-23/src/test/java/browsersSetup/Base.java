package browsersSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base 
{
	public static WebDriver openChromeBrowser()
	{
			System.setProperty("webdriver.chrome.driver", "src/test/resources/browserFiles/chromedriver.exe");
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--disable-notifications");
			WebDriver driver = new ChromeDriver(ops);
			return driver;
	}
	
	public static WebDriver openEdgeBrowser()
	{
		System.setProperty("webdriver.edge.driver", "src/test/resources/browserFiles/msedgedriver.exe");
//		ChromeOptions ops = new ChromeOptions();
//		ops.addArguments("--disable-notifications");
		WebDriver driver = new EdgeDriver();
		return driver;
		
//		EdgeOptions edgeOptions = new EdgeOptions();
//        if(isPrivate) {
//            edgeOptions.addArguments("inprivate");
//        }
//        int locationFlag = location.equals(true) ? 1:2;
//        Map< String, Object > prefs = new HashMap<>();
//        Map < String, Object > profile = new HashMap <> ();
//        Map < String, Object > contentSettings = new HashMap <> ();
//        contentSettings.put("geolocation", locationFlag);
//        profile.put("managed_default_content_settings", contentSettings);
//        prefs.put("profile", profile);
//        edgeOptions.setExperimentalOption("prefs", prefs);
//        caps.merge(edgeOptions);
	}
	
	public static WebDriver openFirefoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "src/test/resources/browserFiles/geckodriver.exe");
//		ChromeOptions ops = new ChromeOptions();
//		ops.addArguments("--disable-notifications");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

}
