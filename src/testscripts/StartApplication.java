package testscripts;

import io.appium.java_client.ios.IOSDriver;
import utility.FlickrApiResponse;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import config.Configration;

public class StartApplication {

	private static IOSDriver driver;

	@BeforeClass
	public void setUp() throws Exception {

		// public static void main(String[] args) throws MalformedURLException,
		// InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("app", "/Users/raggarwal/Downloads/Tech_Test_Testing/FlickrBrowser-cal.app");
		capabilities.setCapability("deviceName", "iPhone 7");
		capabilities.setCapability("automationName", "XCUITEST");
		capabilities.setCapability("noReset", Configration.NO_RESET);

		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Thread.sleep(10000);
		
//		homeScreen = new HomeScreenPage(driver);

	}
	
	@Test
	public void testcase1() throws ClientProtocolException, IOException {
	System.out.println(driver.findElements(By.xpath("//XCUIElementTypeSearchField/XCUIElementTypeSearchField")).size());
	 WebElement webElement=driver.findElement(By.xpath("//XCUIElementTypeSearchField/XCUIElementTypeSearchField"));
	 webElement.sendKeys("continent");
	 webElement.sendKeys(Keys.ENTER);
	 
	 FlickrApiResponse weatherApiResponse=new FlickrApiResponse();
	// String ExpectedString=weatherApiResponse.GetResponse();
	//System.out.println(ExpectedString);
//	 Assert.assertTrue(webElement.getText().equals(ExpectedString));
	}
	
	@Test  
	   public void test_login() throws Exception {  
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
	   
//	     homeScreen.verifyHeader();  
//	     homeScreen.selectTextButton();  
//	   
//	     innerApiDemoScreen.verifyHeader();  
//	     innerApiDemoScreen.selectLogTextBoxButton();  
//	   
//	     logTextBoxPage.verifyHeader();  
//	     logTextBoxPage.selectAddButton();  
//	   
//	     String expectedPanelText = "This is a test";  
//	     String actualPanelText = logTextBoxPage.getPanelText();  
//	   
//	     System.out.println("Checking panel text...");  
//	   
//	     TestUtils.outputIfMatchPassOrFail(expectedPanelText, actualPanelText);  
//	     assertThat(actualPanelText,containsString(expectedPanelText));  
	   }  


	@AfterClass
	public void tearDown() throws Exception {
		
		driver.quit();
	}

}
