package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "onetrust-banner-sdk")
	public WebElement cookiesBanner;
	
	@FindBy(id = "onetrust-pc-btn-handler")
	public WebElement cookiesSettingsBtn;
	
	@FindBy(xpath = "//*[@class='save-preference-btn-handler onetrust-close-btn-handler']")
	public WebElement confirmMyChoicesBtn;
	
	public String getURLOnPageLoad() {
		
		if(cookiesBanner.isDisplayed()) {
			
			cookiesSettingsBtn.click();
			confirmMyChoicesBtn.click();
			
		}
		
		return driver.getCurrentUrl();
		
	}

}
