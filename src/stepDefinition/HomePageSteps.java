package stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

	HashMap<Integer, String> dataFromUI, dataFromApi = new HashMap<Integer, String>();

	@Before
	public void setUp() throws Exception {

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
	public void message_displayed_Result_Successfully() throws Throwable {
		dataFromUI = homeScreenPage.getImagesTitles();
		System.out.println("Result Displayed Successfully");
	}

	@Then("^Get Data using API \"(.*)\"$")
	public void get_Data_Using_API(String searchText) throws Throwable {
		dataFromApi = items.getTitlesApi(searchText);
	}

	@Then("^Titles verified Successfully$")
	public void message_Titles_verified_Successfully() throws Throwable {
		assertEquals(dataFromUI.size(), dataFromApi.size(), "Title Count not equal");
		assertTrue(items.verify(dataFromUI, dataFromApi), "Title are not same");

	}

}
