package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BasePage;
import base.BaseTest;
import extentlisteners.ExtentListeners;
import pages.HomePage;
import utilities.DataUtil;

//TS001_TC001_Currys URL and logo
public class TS001TC001CurrysURLAndLogoTest extends BaseTest{
	
	// Verify the loading of the Currys url and display of its logo
	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp1")
	public void loadPageVerifyURLAndLogo(String browser, String pageLoadURL) {
		
		// Loading the set up for test run
		setUp(browser);

		// Webdriver instance
		HomePage homePage = new HomePage(driver);
		// Accept privacy settings displayed on url load
		BasePage.currysBase.acceptPrivacySettings();
	
		// Retrieve the URL on page load and verify it
		String currentURL = BasePage.currysBase.getURLOnPageLoad();
		
		try {
			Assert.assertEquals(currentURL, pageLoadURL);
			ExtentListeners.test.log(Status.INFO, "The URL navigated is correct: " +currentURL);
			
		}catch(Throwable t){
			ExtentListeners.test.log(Status.FAIL, "The URL navigated is wrong: " +currentURL);
			Assert.fail();
		}
		
		//Verify if the logo is displayed
		BasePage.currysBase.verifyCurrysLogo();

	}

}