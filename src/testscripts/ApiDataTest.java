package testscripts;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import config.Configration;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import pages.HomeScreenPage;
import utility.FlickrApiResponse;

public class ApiDataTest {

	private static IOSDriver driver;
	private String appiumPort = "4723";
	private String serverIp = "127.0.0.1";
	private HomeScreenPage homeScreen;
	// private InnerApiDemosPage innerApiDemoScreen;
	// private LogTextBoxPage logTextBoxPage;

	@BeforeSuite
	public void DesiredCapabilities() throws MalformedURLException {

		System.out.println("Inside initDriver method");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Configration.PLATFORM_NAME);
		capabilities.setCapability(MobileCapabilityType.APP, Configration.APP);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Configration.DEVICE_NAME);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, Configration.AUTOMATION_NAME);
		capabilities.setCapability("noReset", Configration.NO_RESET);
		String serverUrl = "http://" + serverIp + ":" + appiumPort + "/wd/hub";

		try {
			System.out.println("Argument to driver object : " + serverUrl);
			driver = new IOSDriver(new URL(serverUrl), capabilities);

		} catch (NullPointerException | MalformedURLException ex) {
			throw new RuntimeException("appium driver could not be initialised for device ");
		}
		System.out.println("Driver in initdriver is : " + driver);

		homeScreen = new HomeScreenPage(driver);

	}

	@Test
	public void testLogin() throws ClientProtocolException, IOException {
		HomeScreenPage homePage = new HomeScreenPage(driver);
		if (homePage.validateLoginpage() == true) {
			homePage.testLoginWithoutCredentials();
			System.out.println("pass");
		} else {
			System.out.println("Validation failed");
		}

		FlickrApiResponse flickrApiResponse = new FlickrApiResponse();
		HashMap<Integer, String> ExpectedString = flickrApiResponse.GetResponse();
		System.out.println(ExpectedString);

	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
