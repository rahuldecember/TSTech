package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;



public class HomeScreenPage{

	private IOSDriver driver; 
    PageObjects loginPage;


    public HomeScreenPage(IOSDriver driver) {  
        this.driver = driver;  
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);  
      } 
    
    public void enterSearchValue(String searchValue){
    	
    	System.out.println("Home_Screen_Page_PAGE: Enter Search Text...");  
	WebDriverWait wait = new WebDriverWait(this.driver, 30);  
	wait.until(ExpectedConditions.visibilityOf(loginPage.homeSearchFld));
    	loginPage.homeSearchFld.sendKeys(searchValue);
    }
    
    public boolean validateLoginpage(){
        boolean elements = true;
        if(loginPage.homeSearchFld.isDisplayed()){
//            if(loginPage.passwordField.isDisplayed()){
//                if(loginPage.checkBox.isDisplayed()){
//                    if(loginPage.loginBtn.isDisplayed()){
//                        elements = true;
//                    }
//                }
//            }
//        }
//        else{
//            elements = false;
        }
        return elements;


    }

    public boolean testLoginWithoutCredentials() {
        boolean loginStatus = false;
 //      loginPage.loginBtn.click();
//        if (loginPage.inputError.getText().equalsIgnoreCase("Username is mandatory")) {
//            loginStatus = true;
//        }
//        loginPage.userNameFld.sendKeys(userName);
//        loginPage.loginBtn.click();
//        if (loginPage.inputError.getText().equalsIgnoreCase("Password is mandatory")) {
//            loginStatus = true;
//        }
        return loginStatus;

    }
    

    class PageObjects {

        @CacheLookup
        @FindBy(xpath = "//XCUIElementTypeSearchField/XCUIElementTypeSearchField")
        public WebElement homeSearchFld;


    }
}
