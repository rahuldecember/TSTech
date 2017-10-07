package stepDefinition;

import java.util.HashMap;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.ios.IOSDriver;
import pages.HomeScreenPage;
import utility.FlickrApiResponse;
import utility.InitialiseDriver;

public class Test_Steps {
	// public static WebDriver driver;

	private static IOSDriver driver;
	private HomeScreenPage homeScreen;

	@Given("^User is on Home Screen$")
	public void user_is_on_Home_Screen() throws Throwable {
		new InitialiseDriver().setup();
	}

	@When("^User searches for \"(.*)\"$")
	public void user_enters_UserName_and_Password(String searchText) throws Throwable {
		// homeScreen.enterSearchValue(searchText);
	}

	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		// homeScreen = new HomeScreenPage(driver);

	}

	@Then("^Search Result displayed Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
		System.out.println("Login Successfully");

	}

	@When("^Get Data using API$")
	public void get_Data_Using_API() throws Throwable {
		FlickrApiResponse flickrApiResponse = new FlickrApiResponse();
		HashMap<Integer, String> ExpectedString = flickrApiResponse.GetResponse();
		System.out.println(ExpectedString);
	}

	@Then("^Titles verified Successfully$")
	public void message_Displayed_Logout_Successfully() throws Throwable {
		System.out.println("LogOut Successfully");
	}

}
