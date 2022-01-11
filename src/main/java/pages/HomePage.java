package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import base.BasePage;
import extentlisteners.ExtentListeners;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(linkText = "Appliances")
	public WebElement appliances;
	
	@FindBy(linkText = "Washing machines")
	public WebElement washingMachines;
	
	@FindBy(linkText = "Kettles")
	public WebElement kettles;

	@FindBy(linkText = "TV & Audio")
	public WebElement tvAudio;
	
	@FindBy(linkText = "TV wall brackets")
	public WebElement tvWallBrackets;
	
	@FindBy(linkText = "Soundbars")
	public WebElement soundbars;

	@FindBy(linkText = "Computing")
	public WebElement computing;

	@FindBy(linkText = "Gaming")
	public WebElement gaming;

	@FindBy(linkText = "Cameras")
	public WebElement cameras;

	@FindBy(linkText = "Phones")
	public WebElement phones;

	@FindBy(xpath = "//*[text()='Visit Mobile page']")
	public WebElement visitMobilePageBtn;

	@FindBy(linkText = "Smart Tech")
	public WebElement smartTech;

	@FindBy(linkText = "Home & Outdoor")
	public WebElement homeOutdoor;
	
	@FindBy(linkText = "Track your order")
	public WebElement trackYourOrder;
	
	@FindBy(xpath = "//*[@name='search-field']")
	public WebElement searchField;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement searchBtn;
	
	@FindBy(xpath = "(//*[@class='LinkItem__Label-lgtfuY cbWWDQ'])[1]")
	public WebElement stores;
	
	@FindBy(linkText = "Currys Business")
	public WebElement currysBusinessLink;
	
	@FindBy(linkText = "Currys Ireland")
	public WebElement currysIrelandLink;
	
	@FindBy(linkText = "Partmaster")
	public WebElement partmasterLink;
	
	// Method to navigate to Appliances page
	public AppliancesPage goToAppliancesPage() {

		appliances.click();
		return new AppliancesPage(driver);

	}

	// Method to navigate to TV & Audio page
	public TVAudioPage goToTVAudioPage() {

		tvAudio.click();
		return new TVAudioPage(driver);
	}

	// Method to navigate to Computing page
	public ComputingPage goToComputingPage() {

		computing.click();
		return new ComputingPage(driver);

	}

	// Method to navigate to Gaming page
	public GamingPage goToGamingPage() {

		gaming.click();
		return new GamingPage(driver);

	}

	// Method to navigate to Cameras page
	public CamerasPage goToCamerasPage() {

		cameras.click();
		return new CamerasPage(driver);

	}

	// Method to navigate to Phones page
	public PhonesPage goToPhonesPage() {

		phones.click();

		visitMobilePageBtn.click();

		return new PhonesPage(driver);

	}

	// Method to navigate to SmartTech page
	public SmartTechPage goToSmartTechPage() {

		smartTech.click();
		return new SmartTechPage(driver);

	}

	// Method to navigate to HomeOutdoor page
	public HomeOutdoorPage goToHomeOutdoorPage() {

		homeOutdoor.click();
		return new HomeOutdoorPage(driver);

	}
	
	public ItemsDisplayPage goToItemsDisplayPage(String menuName, String productName) {
		
		Actions action = new Actions(driver);
		
		if(menuName.equals("Appliances")) {
			
			action.moveToElement(appliances).perform();
			
			if(productName.equals("Washing machines")) {
					
				try {
					String prodLink = washingMachines.getText();
					washingMachines.click();
					ExtentListeners.test.log(Status.INFO, "Clicked on the product: " +prodLink);
					
				}catch(Throwable t) {
					
					ExtentListeners.test.log(Status.FAIL, t.getMessage());
					Assert.fail();
				}
				
			}else if(productName.equals("Kettles")) {
				
				try {
					String prodLink = kettles.getText();
					kettles.click();
					ExtentListeners.test.log(Status.INFO, "Clicked on the product: " +prodLink);
					
				}catch(Throwable t) {
					
					ExtentListeners.test.log(Status.FAIL, t.getMessage());
					Assert.fail();
				}
				
			}
			
		}else if(menuName.equals("TV & Audio")) {
			
			action.moveToElement(tvAudio).perform();
			
			if(productName.equals("TV wall brackets")) {
				
				try {
					String prodLink = tvWallBrackets.getText();
					tvWallBrackets.click();
					ExtentListeners.test.log(Status.INFO, "Clicked on the product: " +prodLink);
					
				}catch(Throwable t) {
					
					ExtentListeners.test.log(Status.FAIL, t.getMessage());
					Assert.fail();
				}

				
			}else if(productName.equals("Soundbars")) {
				
				try {
					String prodLink = soundbars.getText();
					soundbars.click();
					ExtentListeners.test.log(Status.INFO, "Clicked on the product: " +prodLink);
					
				}catch(Throwable t) {
					
					ExtentListeners.test.log(Status.FAIL, t.getMessage());
					Assert.fail();
				}
				
			}
			
		}
		
		return new ItemsDisplayPage(driver);
		
	}
	
	public TrackMyOrderPage gotoTrackMyOrderPage() {
		
		trackYourOrder.click();		
		return new TrackMyOrderPage(driver);
		
	}

	public void searchProduct(String searchData) {
		
		System.out.println("a");
		searchField.sendKeys(searchData);
		System.out.println("b");
		searchBtn.click();
		System.out.println("c");
		
		/*for(WebElement suggestionPopUpValue: suggestionPopUpList) {
			
			if(suggestionPopUpValue.getText().equals(suggestedValue)) {
				
				suggestionPopUpValue.click();
				
			}*/
			
	}
	
	public ItemsDisplayPage goToItemsDisplayPageViaSearch() {	
		
		return new ItemsDisplayPage(driver);
	}
	
	public CurrysStoreFinderPage goToCurrysStoreFinderPage() {
		
		stores.click();
		return new CurrysStoreFinderPage(driver);
		
	}
	
	public void navigateToOtherCurrysWebsite(String website) {
		
		if(website.equals("Currys Business")) {
			
			currysBusinessLink.click();
			
		}else if(website.equals("Currys Ireland")) {
			
			currysIrelandLink.click();
			
		}else if(website.equals("Partmaster")) {
			
			partmasterLink.click();
			
		}
		
	}
	
}
