package testcases;

import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import pages.HomePage;
import pages.TrackMyOrderPage;
import pages.TrackTodayOrderDeliveryPage;
import utilities.DataUtil;

//TS005_TC001_Track your order to be delivered today
public class TS005TC001TrackYourOrderDeliveryTodayTest extends BaseTest {
	
	//Verify the sucessful tracking of your order to be delivered today
	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp1")
	public void trackYourOrder(String browser, String jobRepairRef, String searchByType, String searchByData, String countryName) {
		
		// Loading the set up for test run
		setUp(browser);

		// Webdriver instance
		HomePage homePage = new HomePage(driver);
		// Accept privacy settings displayed on url load
		BasePage.currysBase.acceptPrivacySettings();
		
		// Track your order to be delivered today
		TrackMyOrderPage trackMyOrderPage = homePage.gotoTrackMyOrderPage();
		TrackTodayOrderDeliveryPage trackerForTodayPage = trackMyOrderPage.goToTrackerForTodayPage();
		trackerForTodayPage.trackTodayOrderDelivery(jobRepairRef, searchByType, searchByData, countryName);
		
	}

}
