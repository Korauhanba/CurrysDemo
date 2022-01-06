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

public class MainMenuPageNavigationTest extends BaseTest {
	
	String actPageTitle, actItemTitle;
	SoftAssert softAssert = new SoftAssert();
	
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

	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp1")
	public void pageNavigation(String browserName, String itemName, String expPageTitle, String expItemTitle) {
		
		setUp(browserName);
		
		HomePage homePage = new HomePage(driver);
		homePage.acceptPrivacySettings();
		
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