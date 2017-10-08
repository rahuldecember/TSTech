package pages;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class HomeScreenPage {
	private AppiumDriver driver;

	public HomeScreenPage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}

	public void enterSearchValue(String searchValue) {

		System.out.println("Home_Screen_Page_PAGE: Enter Search Text...");

		if (homeSearchFld != null) {
			System.out.println(homeSearchFld);
			homeSearchFld.click();
			homeSearchFld.setValue(searchValue);

			// sendKeys(searchValue);
		} else {
			System.out.println("homeSearchFld null");
		}

	}

	public int getImagesCount() {
		int count = 0;
		List<MobileElement> elements = driver.findElements(By.xpath(
				"/AppiumAUT/XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell"));
		count = elements.size();
		return count;
	}

	public HashMap<Integer, String> getImagesTitles() {
		HashMap<Integer, String> hmap = new HashMap<>();
		int count = getImagesCount();

		if (count > 0) {
			for (int i = 0; i < count; i++) {
				String title = driver.findElement(By.xpath(
						"/AppiumAUT/XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[" + i +"]/XCUIElementTypeStaticText")).getText();
				hmap.put(i, title);
			}
		}

		return hmap;
	}

	@iOSFindBy(xpath = "/AppiumAUT/XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSearchField/XCUIElementTypeSearchField")
	public MobileElement homeSearchFld;

	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"FlickrBrowser-cal\"]")
	public MobileElement homeSearchFld1;

	public MobileElement getFirstSearchResult() {
		return homeSearchFld;
	}

}
