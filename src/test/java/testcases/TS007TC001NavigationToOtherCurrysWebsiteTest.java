package testcases;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BasePage;
import base.BaseTest;
import extentlisteners.ExtentListeners;
import pages.HomePage;
import utilities.DataUtil;

// TC007_TC001_Navigation to other Currys website
public class TS007TC001NavigationToOtherCurrysWebsiteTest extends BaseTest {
	
	// Test to navigate to websites - Currys Business, Currys Ireland and Partmaster from the Currys main page
	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp1")
	public void navigateToOtherCurrysWebsites(String browser, String otherWebsite, String expPageTitle, String expURL) {
		
		// Variables declaration for handling multiple windows
		Set<String> windowHandles;
		Iterator<String> iterator;
		String secondWindow;
		
		// Loading the set up for test run
		setUp(browser);

		// Webdriver instance
		HomePage homePage = new HomePage(driver);
		// Accept privacy settings displayed on url load
		BasePage.currysBase.acceptPrivacySettings();
		
		// Navigate to Currys Business, Currys Ireland and Partmaster
		homePage.navigateToOtherCurrysWebsite(otherWebsite);
		
		// Switch to new website window tab
		windowHandles = driver.getWindowHandles();
		iterator = windowHandles.iterator();
		iterator.next();
		secondWindow = iterator.next();
		driver.switchTo().window(secondWindow);
		
		// Retrieve and validate the Page tile and current URL
		String actPageTitle = BasePage.currysBase.getPageTitle();
		String currentURL = BasePage.currysBase.getURLOnPageLoad();
		
		try {
			
			Assert.assertEquals(actPageTitle, expPageTitle);
			ExtentListeners.test.log(Status.INFO, "Page Title matches. Expected & Actual : " +actPageTitle);
			Assert.assertEquals(currentURL, expURL);
			ExtentListeners.test.log(Status.INFO, "The URL navigated is correct: " +currentURL);
			log.info("Navigated to " +otherWebsite+ " page successfully.");
			
		}catch(Throwable t) {
			
			ExtentListeners.test.log(Status.FAIL, t.getMessage());
			log.info(t.getMessage());
			Assert.fail();
			
		}
		
	}

}
