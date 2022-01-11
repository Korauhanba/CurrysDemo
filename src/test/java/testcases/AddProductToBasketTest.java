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

public class AddProductToBasketTest extends BaseTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp1")
	public void addProductToBasket(String browser, String menuName, String prodName, String expProdTitle,
			String expItemBrand, String expItemName, String expItemBasketAddSuccessMsg) {
		
		setUp(browser);

		HomePage homePage = new HomePage(driver);
		BasePage.currysBase.acceptPrivacySettings();

		ItemsDisplayPage prodDisplayPage = homePage.goToItemsDisplayPage(menuName, prodName);
		String actProdTitle = prodDisplayPage.getItemTitle();

		try {
			Assert.assertEquals(actProdTitle, expProdTitle);
			log.info("Product Title displayed: " + actProdTitle);
			ExtentListeners.test.log(Status.INFO, "Product Title displayed: " + actProdTitle);
		} catch (Throwable t) {
			ExtentListeners.test.log(Status.FAIL, t.getMessage());
			log.info("Product Title does not match. Expected : " + expProdTitle + " , Actual: " + actProdTitle);
			Assert.fail();
		}

		ItemDescriptionPage itemDescPage = prodDisplayPage.goToItemOnDescPage(expItemBrand, expItemName);
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
