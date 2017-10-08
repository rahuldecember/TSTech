package stepDefinition;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.Items;
import pages.HomeScreenPage;
import utility.AppiumBaseClass;
import utility.AppiumController;

public class HomePageSteps extends AppiumBaseClass {
	protected HomeScreenPage homeScreenPage;
	Items items = new Items();

	HashMap<Integer, String> dataFromUI = new HashMap<Integer, String>();
	HashMap<Integer, String> dataFromApi = new HashMap<Integer, String>();

	@Before
	public void setUp() throws Exception {
		System.out.println("before");
		AppiumController.instance.start();
		switch (AppiumController.executionOS) {
		case ANDROID:
			homeScreenPage = new HomeScreenPage(driver());
			break;
		case IOS:
			homeScreenPage = new HomeScreenPage(driver());
			break;
		}
	}

	@After
	public void tearDown() {
		AppiumController.instance.stop();
	}

	@Given("^User is on Home Screen$")
	public void user_is_on_Home_Screen() throws Throwable {
		System.out.println("User is on Home Screen");
	}

	@When("^User searches for images with \"(.*)\" text.$")
	public void setSearchParameters(String searchText) throws ClientProtocolException, IOException {
		homeScreenPage.enterSearchValue(searchText);
	}

	@Then("^Search Result displayed Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
		dataFromUI = homeScreenPage.getImagesTitles();
		System.out.println("Login Successfully");
	}

	@Then("^Get Data using API \"(.*)\"$")
	public void get_Data_Using_API(String searchText) throws Throwable {
		dataFromApi = items.getTitlesApi(searchText);
	}

	@Then("^Titles verified Successfully$")
	public void message_Displayed_Logout_Successfully() throws Throwable {
		if (dataFromUI.size() == dataFromApi.size()) {
			items.verify(dataFromUI, dataFromApi);
			System.out.println("Titles verified Successfully");
		}else {
			System.out.println("Test Fails");
		}
		
	}

}
