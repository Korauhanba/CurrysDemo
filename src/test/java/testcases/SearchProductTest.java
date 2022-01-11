package testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BasePage;
import base.BaseTest;
import extentlisteners.ExtentListeners;
import pages.HomePage;
import pages.ItemsDisplayPage;
import utilities.DataUtil;

public class SearchProductTest extends BaseTest {
	
	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp1")
	public void searchProduct(String browser, String searchData, String expPageTitle) {
		
		setUp(browser);
		
		HomePage homePage = new HomePage(driver);
		BasePage.currysBase.acceptPrivacySettings();
		
		
		homePage.searchProduct(searchData);
		ItemsDisplayPage itemsDisplayPage = homePage.goToItemsDisplayPageViaSearch();
		
		String pageTitle = itemsDisplayPage.getItemTitle();
		
		try {
			Assert.assertTrue(pageTitle.contains(expPageTitle));
			log.info("Page title displayed: " +pageTitle);
			ExtentListeners.test.log(Status.INFO, "Page title displayed: " +pageTitle);
		}catch(Throwable t) {
			ExtentListeners.test.log(Status.FAIL, "Expected tile: " +expPageTitle+ ". Actual title: " +pageTitle);
			log.info("Expected tile: " +expPageTitle+ ". Actual title: " +pageTitle);
			Assert.fail();
		}

		
		
	}

}
