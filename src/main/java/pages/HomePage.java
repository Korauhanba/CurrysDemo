package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

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

		try {
			appliances.click();
		} catch (Throwable t) {
			ExtentListeners.test.log(Status.FAIL, t.getMessage());
		}

		return new AppliancesPage(driver);

	}

	// Method to navigate to TV & Audio page
	public TVAudioPage goToTVAudioPage() {

		try {
			tvAudio.click();
		} catch (Throwable t) {
			ExtentListeners.test.log(Status.FAIL, t.getMessage());
		}

		return new TVAudioPage(driver);
	}

	// Method to navigate to Computing page
	public ComputingPage goToComputingPage() {

		try {
			computing.click();
		} catch (Throwable t) {
			ExtentListeners.test.log(Status.FAIL, t.getMessage());
		}

		return new ComputingPage(driver);

	}

	// Method to navigate to Gaming page
	public GamingPage goToGamingPage() {

		try {
			gaming.click();
		} catch (Throwable t) {
			ExtentListeners.test.log(Status.FAIL, t.getMessage());
		}

		return new GamingPage(driver);

	}

	// Method to navigate to Cameras page
	public CamerasPage goToCamerasPage() {

		try {
			cameras.click();
		} catch (Throwable t) {
			ExtentListeners.test.log(Status.FAIL, t.getMessage());
		}

		return new CamerasPage(driver);

	}

	// Method to navigate to Phones page
	public PhonesPage goToPhonesPage() {

		try {
			phones.click();
			visitMobilePageBtn.click();
		} catch (Throwable t) {
			ExtentListeners.test.log(Status.FAIL, t.getMessage());
		}

		return new PhonesPage(driver);

	}

	// Method to navigate to SmartTech page
	public SmartTechPage goToSmartTechPage() {

		try {
			smartTech.click();
		} catch (Throwable t) {
			ExtentListeners.test.log(Status.FAIL, t.getMessage());
		}

		return new SmartTechPage(driver);

	}

	// Method to navigate to HomeOutdoor page
	public HomeOutdoorPage goToHomeOutdoorPage() {

		try {
			homeOutdoor.click();
		} catch (Throwable t) {
			ExtentListeners.test.log(Status.FAIL, t.getMessage());
		}

		return new HomeOutdoorPage(driver);

	}

	// Method to navigate to the Items display page via the menu and sub-menu
	// Few menus and test menu's has been
	public ItemsDisplayPage goToItemsDisplayPage(String menuName, String productName) {

		Actions action = new Actions(driver);

		try {
			if (menuName.equals("Appliances")) {

				action.moveToElement(appliances).perform();

				if (productName.equals("Washing machines")) {

					String prodLink = washingMachines.getText();
					washingMachines.click();
					ExtentListeners.test.log(Status.INFO, "Clicked on the product: " + prodLink);

				} else if (productName.equals("Kettles")) {

					String prodLink = kettles.getText();
					kettles.click();
					ExtentListeners.test.log(Status.INFO, "Clicked on the product: " + prodLink);

				}

			} else if (menuName.equals("TV & Audio")) {

				action.moveToElement(tvAudio).perform();

				if (productName.equals("TV wall brackets")) {

					String prodLink = tvWallBrackets.getText();
					tvWallBrackets.click();
					ExtentListeners.test.log(Status.INFO, "Clicked on the product: " + prodLink);

				} else if (productName.equals("Soundbars")) {

					String prodLink = soundbars.getText();
					soundbars.click();
					ExtentListeners.test.log(Status.INFO, "Clicked on the product: " + prodLink);

				}
			}

		} catch (Throwable t) {
			ExtentListeners.test.log(Status.INFO, t.getMessage());
		}

		return new ItemsDisplayPage(driver);

	}

	public TrackMyOrderPage gotoTrackMyOrderPage() {

		try {
			trackYourOrder.click();
		} catch (Throwable t) {
			ExtentListeners.test.log(Status.FAIL, t.getMessage());
		}

		return new TrackMyOrderPage(driver);

	}

	// Method to search product by entering data in the search field
	public void searchProduct(String searchData) {

		try {
			searchField.sendKeys(searchData);
			searchBtn.click();
		} catch (Throwable t) {
			ExtentListeners.test.log(Status.FAIL, t.getMessage());
		}

	}

	public ItemsDisplayPage goToItemsDisplayPageViaSearch() {

		return new ItemsDisplayPage(driver);
	}

	public CurrysStoreFinderPage goToCurrysStoreFinderPage() {

		try {
			stores.click();
		} catch (Throwable t) {
			ExtentListeners.test.log(Status.FAIL, t.getMessage());
		}

		return new CurrysStoreFinderPage(driver);

	}

	public void navigateToOtherCurrysWebsite(String website) {

		if (website.equals("Currys Business")) {

			try {
				currysBusinessLink.click();
			} catch (Throwable t) {
				ExtentListeners.test.log(Status.FAIL, t.getMessage());
			}

		} else if (website.equals("Currys Ireland")) {

			try {
				currysIrelandLink.click();
			} catch (Throwable t) {
				ExtentListeners.test.log(Status.FAIL, t.getMessage());
			}

		} else if (website.equals("Partmaster")) {

			try {
				partmasterLink.click();
			} catch (Throwable t) {
				ExtentListeners.test.log(Status.FAIL, t.getMessage());
			}

		}

	}

}
