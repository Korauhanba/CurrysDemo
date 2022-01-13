package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BasePage;
import base.BaseTest;
import extentlisteners.ExtentListeners;
import pages.CurrysStoreDisplayPage;
import pages.CurrysStoreFinderPage;
import pages.HomePage;
import utilities.DataUtil;

public class TS006TC001FindAStoreTest extends BaseTest{
	
	// Test to find a Currys physical store
	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp1")
	public void currysStoreFinder(String browser, String townPostcode, String expStore) {
		
		// Loading the set up for test run
		setUp(browser);

		// Webdriver instance
		HomePage homePage = new HomePage(driver);
		// Accept privacy settings displayed on url load
		BasePage.currysBase.acceptPrivacySettings();
		
		// Navigate to Currys Store Finder Page, enter town / postcode and search the store
		CurrysStoreFinderPage currysStoreFinderPage = homePage.goToCurrysStoreFinderPage();
		CurrysStoreDisplayPage currysStoreDisplayPage = currysStoreFinderPage.goToCurrysStoreDisplayPage(townPostcode);
		String nearestStore = currysStoreDisplayPage.getNearestStore();
		
		// Validate the display of the nearest store based on the search
		try {
			Assert.assertEquals(nearestStore, expStore);
			log.info("Town/Postcode: " +townPostcode+ ". Nearest store: " +nearestStore);
			ExtentListeners.test.log(Status.INFO, "Town/Postcode: " +townPostcode+ ". Nearest store: " +nearestStore);
		}catch(Throwable t) {
			ExtentListeners.test.log(Status.FAIL, "Expected Nearest store: " +expStore+ ". Actual nearest store: " +nearestStore);
			log.info("Expected Nearest store: " +expStore+ ". Actual nearest store: " +nearestStore);
			Assert.fail();
		}
		
	}

}
