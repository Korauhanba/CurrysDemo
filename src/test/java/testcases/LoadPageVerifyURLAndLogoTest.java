package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BasePage;
import base.BaseTest;
import extentlisteners.ExtentListeners;
import pages.HomePage;
import utilities.DataUtil;

public class LoadPageVerifyURLAndLogoTest extends BaseTest{
	
	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp1")
	public void loadPageVerifyURLAndLogo(String browserName, String pageLoadURL) {
		
		setUp(browserName);
		
		HomePage homePage = new HomePage(driver);
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