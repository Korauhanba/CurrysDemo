package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "onetrust-banner-sdk")
	public WebElement cookiesBanner;

	@FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
	public WebElement acceptAllCookiesBtn;

	@FindBy(linkText = "Appliances")
	public WebElement appliances;

	@FindBy(linkText = "TV & Audio")
	public WebElement tvAudio;

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

	// Method to accept user privacy settings if displayed
	public void acceptPrivacySettings() {

		if (cookiesBanner.isDisplayed()) {

			acceptAllCookiesBtn.click();

		}

	}

	// Method to accept privacy settings on first time page load
	public String getURLOnPageLoad() {

		return driver.getCurrentUrl();

	}

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

}
