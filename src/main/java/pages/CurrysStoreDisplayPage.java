package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class CurrysStoreDisplayPage extends BasePage {

	public CurrysStoreDisplayPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "(//*[@class='LocationListItem__StyledH3-sc-1epn3lv-0 eKTIdQ'])[1]")
	public WebElement nearestStore;
	
	public String getNearestStore() {
		
		return nearestStore.getText();
		
	}

}
