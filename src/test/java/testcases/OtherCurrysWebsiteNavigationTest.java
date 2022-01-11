package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import base.BasePage;
import base.BaseTest;
import extentlisteners.ExtentListeners;
import pages.HomePage;
import utilities.DataUtil;

public class OtherCurrysWebsiteNavigationTest extends BaseTest {
	
	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp1")
	public void otherCurrysWebsiteNavigation(String browser, String otherWebsite, String expPageTitle, String expURL) {
		
		setUp(browser);
		
		HomePage homePage = new HomePage(driver);
		SoftAssert softAssert = new SoftAssert();
		
		BasePage.currysBase.acceptPrivacySettings();
		
		homePage.navigateToOtherCurrysWebsite(otherWebsite);
		
		String actPageTitle = BasePage.currysBase.getPageTitle();
		String currentURL = BasePage.currysBase.getURLOnPageLoad();
		
		try {
			
			softAssert.assertEquals(actPageTitle, expPageTitle);
			ExtentListeners.test.log(Status.INFO, "Page Title matches. Expected & Actual : " +actPageTitle);
			softAssert.assertEquals(currentURL, expURL);
			ExtentListeners.test.log(Status.INFO, "The URL navigated is correct: " +currentURL);
			softAssert.assertAll();
			log.info("Navigated to " +otherWebsite+ " page successfully.");
			
		}catch(Throwable t) {
			
			ExtentListeners.test.log(Status.FAIL, "Either navigation to " +otherWebsite+ " page failed or Page Title / URL does not match.");
			log.info("Navigation to " +otherWebsite+ " page failed.");
			Assert.fail();
			
		}
		
	}

}
