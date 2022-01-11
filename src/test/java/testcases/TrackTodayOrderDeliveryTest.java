package testcases;

import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import pages.HomePage;
import pages.TrackMyOrderPage;
import pages.TrackTodayOrderDeliveryPage;
import utilities.DataUtil;

public class TrackTodayOrderDeliveryTest extends BaseTest {
	
	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp1")
	public void trackOurOrder(String browser, String jobRepairRef, String searchByType, String searchByData, String countryName) {
		
		setUp(browser);
		
		HomePage homePage = new HomePage(driver);
		BasePage.currysBase.acceptPrivacySettings();
		
		TrackMyOrderPage trackMyOrderPage = homePage.gotoTrackMyOrderPage();
		TrackTodayOrderDeliveryPage trackerForTodayPage = trackMyOrderPage.goToTrackerForTodayPage();
		trackerForTodayPage.trackTodayOrderDelivery(jobRepairRef, searchByType, searchByData, countryName);
		
	}

}
