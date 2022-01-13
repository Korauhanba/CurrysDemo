package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BasePage;
import base.BaseTest;
import extentlisteners.ExtentListeners;
import pages.HomePage;
import pages.ItemDescriptionPage;
import pages.ItemsDisplayPage;
import utilities.DataUtil;

//TS004_TC001_Add items to Product Basket
public class TS004TC001AddItemsToProductBasketTest extends BaseTest {

	//Verify that an item can be added to the product basket
	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp1")
	public void addProductToBasket(String browser, String menuName, String prodName, String expProdTitle,
			String expItemBrand, String expItemName, String expItemBasketAddSuccessMsg) {
		
		// Loading the set up for test run
		setUp(browser);

		// Webdriver instance
		HomePage homePage = new HomePage(driver);
		// Accept privacy settings displayed on url load
		BasePage.currysBase.acceptPrivacySettings();
		
		//Navigate to the Items display page, retrieve the title and validate it
		ItemsDisplayPage itemDisplayPage = homePage.goToItemsDisplayPage(menuName, prodName);
		String actProdTitle = itemDisplayPage.getItemTitle();

		try {
			Assert.assertEquals(actProdTitle, expProdTitle);
			log.info("Product Title displayed: " + actProdTitle);
			ExtentListeners.test.log(Status.INFO, "Product Title displayed: " + actProdTitle);
		} catch (Throwable t) {
			ExtentListeners.test.log(Status.FAIL, t.getMessage());
			log.info("Product Title does not match. Expected : " + expProdTitle + " , Actual: " + actProdTitle);
			Assert.fail();
		}

		//Navigate to the Ttems description page, retrieve the title and validate it
		ItemDescriptionPage itemDescPage = itemDisplayPage.goToItemOnDescPage(expItemBrand, expItemName);
		String itemTitleDescPage = itemDescPage.getItemTitleItemDescPage();

		try {
			Assert.assertEquals(itemTitleDescPage, expItemBrand + " " + expItemName);
			ExtentListeners.test.log(Status.INFO, "The item title matches. Item description page : " + itemTitleDescPage
					+ " & Product Display page: " + expItemBrand + " " + expItemName);
			log.info("The product title matches. Product description page : " + itemTitleDescPage
					+ " & Product Display page: " + expItemBrand + " " + expItemName);

		} catch (Throwable t) {

			ExtentListeners.test.log(Status.FAIL, t.getMessage());
			log.info(t.getMessage());
			Assert.fail();

		}

		// Add item to basket and validate the success message
		itemDescPage.addItemToBasket();
		
		try {
			
			Assert.assertEquals(itemDescPage.getItemAddedSuccessMsg(), expItemBasketAddSuccessMsg);
			Assert.assertEquals(itemDescPage.getItemNameOnAddedSuccessMsg(), itemTitleDescPage);
			log.info("Item " +itemTitleDescPage+ " has been successfully added to basket.");
			ExtentListeners.test.log(Status.INFO, "Item " +itemTitleDescPage+ " has been successfully added to basket.");

		} catch (Throwable t) {

			ExtentListeners.test.log(Status.FAIL, t.getMessage());
			log.info(t.getMessage());
			Assert.fail();

		}

	}

}
