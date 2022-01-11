package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import base.BasePage;

public class ItemsDisplayPage extends BasePage {

	public ItemsDisplayPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[@class='ConnectedHeaderTitle__StyledH1-sc-ckick5-0 qumlm pageTitle']")
	public WebElement itemTitleDisplayPage;

	@FindBy(xpath = "//*[@data-product='brand']")
	public List<WebElement> itemBrands;

	@FindBy(xpath = "//*[@data-product='name']")
	public List<WebElement> itemNames;

	// Method to fetch the product title
	public String getItemTitle() {

		return itemTitleDisplayPage.getText();

	}

	public ItemDescriptionPage goToItemOnDescPage(String expItemBrand, String expItemName) {

		label: for (WebElement itemBrand : itemBrands) {

			if (itemBrand.getText().equals(expItemBrand)) {

				for (WebElement itemName : itemNames) {

					if (itemName.getText().equals(expItemName)) {

						itemName.click();
						break label;

					}
				}
			}
		}
	
		return new ItemDescriptionPage(driver);

	}
	
/*	public void searchedItemListed(String searchData) {
		
		for (WebElement itemName : itemNames) {

			try {
				Assert.assertTrue(itemName.getText().contains(searchData));
				log.info("");
				
			}catch(Throwable t) {
				
				
				
			}
			
			
			
		}*/
		


}
