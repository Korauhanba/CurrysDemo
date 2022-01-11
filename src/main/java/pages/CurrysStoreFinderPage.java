package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class CurrysStoreFinderPage extends BasePage{

	public CurrysStoreFinderPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//*[@class='Input__InputElement-hruajR fGtYHv']")
	public WebElement townPostcodeField;

	@FindBy(xpath = "//span[@class='Icon__Wrapper-hIbNMr fxrytQ dc-icon dc-icon-search Icon-clGvuk fPauNP']")
	public WebElement searchBtn;
	
	public CurrysStoreDisplayPage goToCurrysStoreDisplayPage(String townPostcode){
		
		townPostcodeField.sendKeys(townPostcode);
		searchBtn.click();
		
		return new CurrysStoreDisplayPage(driver);
		
	}

}
