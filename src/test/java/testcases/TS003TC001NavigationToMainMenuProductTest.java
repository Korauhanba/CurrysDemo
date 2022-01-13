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

//TS003_TC001_Navigation to main menu product page
public class TS003TC001NavigationToMainMenuProductTest extends BaseTest {
	
	String actPageTitle, actItemTitle;
	SoftAssert softAssert = new SoftAssert();
	
	// Method to validate the item title on the page
	public void pageItemTitleValidation(String itemName, String expPageTitle, String expItemTitle){
		
		try {
			
			actPageTitle = BasePage.currysBase.getPageTitle();
			
		}catch(Throwable t) {
			
			ExtentListeners.test.log(Status.FAIL, t.getMessage());
		}

		if(itemName.equals("Phones")) {
			
			actItemTitle = BasePage.currysBase.getMobileTitle();
			
		}else {
			
			try {
				actItemTitle = BasePage.currysBase.getItemTitle();
			}catch(Throwable t){
				ExtentListeners.test.log(Status.FAIL, t.getMessage());
			}
	
		}
		
		try {
			
			softAssert.assertEquals(actPageTitle, expPageTitle);
			ExtentListeners.test.log(Status.INFO, "Title displayed on the page: " +actPageTitle);
			softAssert.assertEquals(actItemTitle, expItemTitle);
			ExtentListeners.test.log(Status.INFO, "Item name displayed on the page: " +actItemTitle);
			softAssert.assertAll();
			log.info("Navigated to " +itemName+ " page");
			
		}catch(Throwable t) {
			
			ExtentListeners.test.log(Status.FAIL, "Either navigation to " +itemName+ " page failed or Page Title or Item Title is missing.");
			log.info("Navigation to " +itemName+ " page failed.");
			Assert.fail();
			
		}
		
	}

	// Verify the successful navigation to a product page via the main menu
	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp1")
	public void pageNavigation(String browser, String itemName, String expPageTitle, String expItemTitle) {
		
		// Loading the set up for test run
		setUp(browser);

		// Webdriver instance
		HomePage homePage = new HomePage(driver);
		// Accept privacy settings displayed on url load
		BasePage.currysBase.acceptPrivacySettings();
		
		// Navigation to a product page via the main menu
		if(itemName.equals("Appliances")) {
			
			homePage.goToAppliancesPage();
			pageItemTitleValidation(itemName, expPageTitle, expItemTitle);		
		
		}else if(itemName.equals("TV & Audio")) {
			
			homePage.goToTVAudioPage();
			pageItemTitleValidation(itemName, expPageTitle, expItemTitle);				
			
		}else if(itemName.equals("Computing")) {
			
			homePage.goToComputingPage();
			pageItemTitleValidation(itemName, expPageTitle, expItemTitle);				
			
		}else if(itemName.equals("Gaming")) {
			
			homePage.goToGamingPage();
			pageItemTitleValidation(itemName, expPageTitle, expItemTitle);				
			
		}else if(itemName.equals("Cameras")) {
			
			homePage.goToCamerasPage();
			pageItemTitleValidation(itemName, expPageTitle, expItemTitle);				
			
		}else if(itemName.equals("Phones")) {
			
			homePage.goToPhonesPage();
			pageItemTitleValidation(itemName, expPageTitle, expItemTitle);				
			
		}else if(itemName.equals("Smart Tech")) {
			
			homePage.goToSmartTechPage();
			pageItemTitleValidation(itemName, expPageTitle, expItemTitle);				
			
		}else if(itemName.equals("Home & Outdoor")) {
			
			homePage.goToHomeOutdoorPage();
			pageItemTitleValidation(itemName, expPageTitle, expItemTitle);				
			
		}
		
		actPageTitle = null; 
		actItemTitle = null;
		
	}
	
}