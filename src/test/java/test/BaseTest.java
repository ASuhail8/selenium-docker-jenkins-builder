package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	protected WebDriver driver;

	@BeforeTest
	public void setupDriver() throws MalformedURLException {
		// BROWSER => chrome/firefox
		// HUB_HOST => localhost / 10.0.1.3 / hostname

		String host = "localhost";

		if (System.getProperty("HUB_HOST") != null) {
			host = System.getProperty("HUB_HOST");
		}

		String completeUrl = "http://" + host + ":4444/wd/hub";

		if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
			FirefoxOptions firfoxOptions = new FirefoxOptions();
			driver = new RemoteWebDriver(new URL(completeUrl), firfoxOptions);
		} else {
			ChromeOptions chromeOptions = new ChromeOptions();
			driver = new RemoteWebDriver(new URL(completeUrl), chromeOptions);
		}

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
