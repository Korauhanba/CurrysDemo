package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BasePage;
import base.BaseTest;
import extentlisteners.ExtentListeners;
import pages.HomePage;
import pages.ItemsDisplayPage;
import utilities.DataUtil;

//TS002_TC001_Search available items
public class TS002TC001SearchAvailableItemsTest extends BaseTest {

	// Verify the search of available items
	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp1")
	public void searchProduct(String browser, String searchData, String expPageTitle) {

		// Loading the set up for test run
		setUp(browser);

		// Webdriver instance
		HomePage homePage = new HomePage(driver);
		// Accept privacy settings displayed on url load
		BasePage.currysBase.acceptPrivacySettings();

		// Search the product based on existing product data entered
		homePage.searchProduct(searchData);
		ItemsDisplayPage itemsDisplayPage = homePage.goToItemsDisplayPageViaSearch();

		// Retrieve the page header and validate it
		String pageTitle = itemsDisplayPage.getItemTitle();

		try {
			Assert.assertTrue(pageTitle.contains(expPageTitle));
			log.info("Page title displayed: " + pageTitle);
			ExtentListeners.test.log(Status.INFO, "Page title displayed: " + pageTitle);
		} catch (Throwable t) {
			ExtentListeners.test.log(Status.FAIL, "Expected tile: " + expPageTitle + ". Actual title: " + pageTitle);
			log.info("Expected tile: " + expPageTitle + ". Actual title: " + pageTitle);
			Assert.fail();
		}

	}

}
